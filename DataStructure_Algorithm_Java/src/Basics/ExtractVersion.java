package Basics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractVersion {
	public static void main(String args[]){
		String line = "sdalkdnsalnfsanlfanliafnli \n 0=2.12.5.6.1234abcd ninfdailnfalnfdlif\nBUILD (tons of other junk here)";
		System.out.println(line);
		Matcher matcher = Pattern.compile("((\\d+\\.)+\\d+)").matcher(line);
		if (matcher.find())
		    System.out.println(matcher.group());
		
	}
}
