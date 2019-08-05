package com.usa.federal.gov.ssa.utility;
/**
 * This is the utility class
 * @author manash
 */
public final class SSNAppsUtil {
	private SSNAppsUtil() {
		
	}
	/**
	 * This Method is used to convert ssn number to String format(like 778-85-999).
	 * @param ssnNo
	 * @return String
	 */
	public static String formatSSNNumber(final Long ssnNo) {
		String str=null;
		StringBuffer strBuff=null;
		str=String.valueOf(ssnNo);
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