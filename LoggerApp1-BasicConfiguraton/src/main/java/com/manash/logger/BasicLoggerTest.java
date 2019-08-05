package com.manash.logger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class BasicLoggerTest {
	//create logger object
	private static Logger logger=Logger.getLogger(BasicLoggerTest.class);

	public static void main(String[] args) {
        //Initialize the basicConfigurer
		BasicConfigurator.configure();
		//write log messages
		logger.debug("This is the debug message");
		logger.error("This is the error message");
		logger.warn("This is the warn message");
		logger.fatal("This is the fetal message");
		logger.trace("This is the trace message");
		logger.info("This is the INFO message");
	}

}
