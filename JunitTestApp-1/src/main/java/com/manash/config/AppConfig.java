package com.manash.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {PersistanceConfig.class,ServiceConfig.class})
public class AppConfig {

}
