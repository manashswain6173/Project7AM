package com.usa.his.admin.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration 
@EnableConfigurationProperties
@ConfigurationProperties(value="apps")
@Data
public class AppsMessage {

	private Map<String,String> properties=new HashMap<String,String>();
}
