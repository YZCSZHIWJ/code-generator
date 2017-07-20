package com.jeeffy.code.util;

public class StringUtil {

	private static final char SEPARATOR = '_';
	
    /**
     * wrapper string with template language
     * @param str
     * @return
     */
    public static String wrapper(String str){
        return "${"+str+"}";
    }
    
	public static String firstLowerCase(String str){
		str = str.substring(0, 1).toLowerCase() + str.substring(1);
		return str;
	}

	public static String firstUpperCase(String str) {
		if (str == null) {
			return null;
		}
		str = camelCase(str);
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	@Deprecated
	public static String toUnderscoreCase(String str) {
		if (str == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder();
		boolean upperCase = false;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			boolean nextUpperCase = true;
			if (i < (str.length() - 1)) {
				nextUpperCase = Character.isUpperCase(str.charAt(i + 1));
			}
			if (Character.isUpperCase(c)) {
				if (!upperCase || !nextUpperCase) {
					if (i > 0)
						sb.append(SEPARATOR);
				}
				upperCase = true;
			} else {
				upperCase = false;
			}
			sb.append(Character.toLowerCase(c));
		}
		return sb.toString();
	}

	public static String camelCase(String str) {
		if (str == null) {
			return null;
		}
		str = str.toLowerCase();
		StringBuilder sb = new StringBuilder(str.length());
		boolean upperCase = false;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == SEPARATOR) {
				upperCase = true;
			} else if (upperCase) {
				sb.append(Character.toUpperCase(c));
				upperCase = false;
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static String removePrefix(String str){
		return str.substring(str.length());
	}
	
	public static String removeLast(String str, String rm){
		int last = str.lastIndexOf(rm);
		String s = str.substring(0, last)+str.substring(last+rm.length());
		return s;
	}
}
