package com.fortegroup.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;


/**
 * Web config for this project
 * @author Alexey Burov
 * @version 1.0
 */
@EnableWebMvc
@ComponentScan("com.fortegroup")
public class WebConfig {

}
