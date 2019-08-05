package com.manash.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * This is the common utility class to perform some common operation on the project.
 * @author manash
 *
 */
public class SSNAppsUtil {
	/**
	 * This method converts the java.util.Date object to java.sql.Date object.
	 * It takes the java.util.Date class as method parameter and returns the java.sql.Date class object.
	 * @param utilDate
	 * @return sqlDate
	 */
	public static java.sql.Date convertSQLDate(java.util.Date utilDate){
		DateFormat format=new SimpleDateFormat("dd/mm/yyyy");
		String date=format.format(utilDate);
		try {
			utilDate=format.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new java.sql.Date(utilDate.getTime());
	}
	/**
	 * This Method is used to convert ssn number to String format(like 778-85-999).
	 * @param ssnNo
	 * @return String
	 */
	public static String formatSSNNumber(Long ssnNo) {
		String str=null;
		StringBuffer strBuff=null;
		//convert long value to string object
		str=String.valueOf(ssnNo);
		//create string buffer object
		 strBuff=new StringBuffer("");
		 for(int i=0;i<str.length();++i) {
			 if(i==3 || i==5) {
				 strBuff.append("-");
			 }
			 strBuff.append(str.charAt(i));
		 }
		return strBuff.toString();
	}

}
