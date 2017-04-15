package com.fortegroupe.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fortegroupe.model.Message;
import com.fortegroupe.model.User;
import com.fortegroupe.service.UserService;
import com.fortegroupe.utill.MessageFactory;
import com.fortegroupe.utill.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sazzad on 2/11/16
 */
@RestController
public class HomeController {

    @Autowired
    private UserService userService;
    @Autowired
    private ObjectMapper objectMapper;





    @RequestMapping(value = "/rest/account/singIn", method = RequestMethod.POST)
    public String singIn(@RequestBody User user) throws JsonProcessingException {
        User daoUser = userService.getUserByEmail(user);
        Message message;
        if(daoUser != null)
            message = MessageFactory.getMessage(user.getEmail(),false,"User successfully logging");
        else
            message = MessageFactory.getMessage(user.getEmail(),true,"Email or password not valid!");
        return objectMapper.writeValueAsString(message);
    }

    @RequestMapping(value = "/rest/account/register", method = RequestMethod.POST)
    public String registerUser(@RequestBody User user) throws JsonProcessingException {

        if(!UserValidator.validateEmail(user.getEmail()))
            return objectMapper.writeValueAsString
                    (MessageFactory.getMessage(user.getEmail(),true,"Email not valid!"));
        if(!UserValidator.validatePassword(user.getPassword()))
            return objectMapper.writeValueAsString
                    (MessageFactory.getMessage(user.getEmail(),true,"Password not valid!"));

        User daoUser = userService.registerUser(user);
        Message message;
        if(daoUser != null)
            message = MessageFactory.getMessage(user.getEmail(),false,"User successfully register");
        else
            message = MessageFactory.getMessage
                    (user.getEmail(),true,"Something wrong user not register");
        return objectMapper.writeValueAsString(message);

    }


    @RequestMapping(value = "/rest/account/checkEmail", method = RequestMethod.POST)
    public String checkEmail(@RequestBody User user) throws JsonProcessingException {
        boolean isExist = userService.checkEmail(user.getEmail());
        Message message;
        if(isExist)
            message = MessageFactory.getMessage(user.getEmail(),isExist,"This email exist");
        else
            message = MessageFactory.getMessage(user.getEmail(),isExist,"Email not exist");
        return objectMapper.writeValueAsString(message);
    }

    @RequestMapping(value = "/rest/account/logout",method = RequestMethod.POST)
    public String logOut() throws JsonProcessingException {
        return objectMapper.writeValueAsString
                (MessageFactory.getMessage(null,false,"User successfully logout"));
    }

}
