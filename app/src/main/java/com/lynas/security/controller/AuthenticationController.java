package com.lynas.security.controller;

import com.lynas.AppConstant;
import com.lynas.model.User;
import com.lynas.security.TokenUtils;
import com.lynas.security.model.AuthenticationRequest;
import com.lynas.security.model.AuthenticationResponse;
import com.lynas.security.model.Message;
import com.lynas.security.model.SpringSecurityUser;
import com.lynas.security.utill.MessageFactory;
import com.lynas.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/rest/account")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AppUserService userService;

    @RequestMapping(value = "/singIn",method = RequestMethod.POST)
    public ResponseEntity<?> authenticationRequest(@RequestBody AuthenticationRequest authenticationRequest)
            throws AuthenticationException {

        // Perform the authentication
        Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        System.out.println(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println(SecurityContextHolder.getContext().getAuthentication());

        // Reload password post-authentication so we can generate token
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        String token = this.tokenUtils.generateToken(userDetails);

        // Return the token
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

    @RequestMapping(value = "refresh", method = RequestMethod.GET)
    public ResponseEntity<?> authenticationRequest(HttpServletRequest request) {
        String token = request.getHeader(AppConstant.tokenHeader);
        String username = this.tokenUtils.getUsernameFromToken(token);
        SpringSecurityUser user = (SpringSecurityUser) this.userDetailsService.loadUserByUsername(username);
        if (this.tokenUtils.canTokenBeRefreshed(token, user.getLastPasswordReset())) {
            String refreshedToken = this.tokenUtils.refreshToken(token);
            return ResponseEntity.ok(new AuthenticationResponse(refreshedToken));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResponseEntity<?> registerRequest(@RequestBody User user){
        User registeredUser = userService.saveUser(user);

        AuthenticationRequest request = new AuthenticationRequest
                (registeredUser.getUsername(), user.getPassword());

        return authenticationRequest(request);
    }

    @RequestMapping(value = "/checkEmail",method = RequestMethod.POST)
    public ResponseEntity<?> checkEmail(@RequestBody User user){
        if(user.getUsername() != null){
            User daoUser = userService.loadUserByUsername(user.getUsername());
            Message msg;
            if(daoUser != null){
                msg = MessageFactory.getMessage
                        ("This is email exist",true,null);
            }else {
                msg = MessageFactory.getMessage
                        ("This email not exist",false,null);
            }
            return ResponseEntity.ok(msg);

        }
        else
            return ResponseEntity.ok(MessageFactory.getMessage
                    ("Email must be not null",true,null));

    }

}
