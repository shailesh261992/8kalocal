package com.project.messdeck.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.project.messdeck.aspects" })
public class AOPConfiguration {

}
