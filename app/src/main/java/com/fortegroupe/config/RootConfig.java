package com.fortegroupe.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Root configuration class for Spring
 * @author Alexey burov
 * @version 1.0
 */
@Configuration
@ComponentScan(basePackages={"com.fortegroupe"},
        excludeFilters={
                @ComponentScan.Filter(type= FilterType.ANNOTATION, value=EnableWebMvc.class)
        })
public class RootConfig {}
