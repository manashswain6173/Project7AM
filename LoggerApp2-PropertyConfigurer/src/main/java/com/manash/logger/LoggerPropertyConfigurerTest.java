package com.manash.logger;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerPropertyConfigurerTest {
	
	//Initialize the logger object
	private static Logger logger=Logger.getLogger(LoggerPropertyConfigurerTest.class);

	public static void main(String[] args) {
		
		PropertyConfigurator.configure(System.getProperty("user.dir")+File.separator+"log4j.properties");
       
		logger.debug("This is the debug message");
		logger.error("This is the error message");
		logger.warn("This is the warn message");
		logger.fatal("This is the fetal message");
		logger.trace("This is the trace message");
		logger.info("This is the INFO message");
	}

}
