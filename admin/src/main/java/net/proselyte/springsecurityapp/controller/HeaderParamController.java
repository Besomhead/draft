package net.proselyte.springsecurityapp.controller;

import net.proselyte.springsecurityapp.model.HeaderParam;
import net.proselyte.springsecurityapp.service.HeaderParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/rest/edit/header")
public class HeaderParamController {

    @Autowired
    private HeaderParamService headerParamService;

    @RequestMapping(value = "/getText",method = RequestMethod.GET)
    public ResponseEntity<?> getText(){
        List<HeaderParam> headerParams = new ArrayList<>();
    }

}

