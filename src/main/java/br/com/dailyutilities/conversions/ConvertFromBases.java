package br.com.dailyutilities.conversions;

public class ConvertFromBases {

	public static Integer convertBase16ToBase10(String hexString) {
		
		Integer hex = Integer.parseInt("03", 16);
		
        System.out.println("Converting ("+hexString+") from base-16 to base-10: " + hex);
		
		return hex;
	}
	
}
