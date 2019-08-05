package com.manash.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({RestTemplateConfig.class,ServiceConfig.class,WebClientConfig.class})
public class AppsConfig {

}
