package util;

public class StringUtil {

	public static String repeatString(String word, int repeat) {
		if(repeat < 0)
			throw new IllegalArgumentException("the param repeat can't be negative");
		
		String result = "";
		for (int i = 0; i < repeat; i++) {
			result += word;
		}
		return result;
	}
	
	 public static boolean isEmpty(String str) {
		 return str == null || str.trim().length() <= 0;			
	 }
	
}
