package com.manash.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(value = "apps")
public class AppsMsg {
	
	private Map<String,Object> msgs=new HashMap<String,Object>();

	public Map<String, Object> getMsgs() {
		return msgs;
	}

	public void setMsgs(Map<String, Object> msgs) {
		this.msgs = msgs;
	}

}
