package berlinclock;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.platform.commons.util.StringUtils;

public class Main {
	
	String TIME24HOURS_PATTERN =  "([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";
    final Pattern pattern = Pattern.compile(TIME24HOURS_PATTERN);
   
    
	String berlinClock(String time) {
		 Matcher matcher = pattern.matcher(time);
		 if(! matcher.matches()) return "";
		 
		 
		    LocalTime localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm:ss"));
		    int hour = localTime.get(ChronoField.CLOCK_HOUR_OF_DAY);
		    int minute = localTime.get(ChronoField.MINUTE_OF_HOUR);
		    int second = localTime.get(ChronoField.SECOND_OF_MINUTE);
		    int five=5;
		    String light="O";
		    boolean isEven=false;
		    if ((second % 2) == 0) {
		    	isEven=true;
		    	light="Y";
		    }
		    
		   int resMin= minute/five;
		   
		   String yellowString="";
		   String forthRow="";
		   String firstRow="";
		   String secondRow="";
		  
		   for (int i = 1; i < resMin+1; i++) {
			   if((i>2)&&(i % 3) == 0) yellowString=yellowString+"R";
			   else yellowString=yellowString+"Y";
		   
		   }
		   
		   yellowString= padLeftZeros(yellowString, 11);
		   
		    int remainMin=minute % 5;
		    for (int i = 0; i < remainMin; i++) {
		    	forthRow=forthRow+"Y";
			}
		    
		    forthRow= padLeftZeros(forthRow, 4);

		    int resHour= hour/five;
		    int secondHour= hour%5;
		    for (int i = 1; i < resHour+1; i++) {
				 firstRow=firstRow+"R";
			}
		    
		    for (int i = 1; i < secondHour+1; i++) {
		    	secondRow=secondRow+"R";
			}
		    
		    firstRow= padLeftZeros(firstRow, 4);
		    secondRow= padLeftZeros(secondRow, 4);
		    if(firstRow.equals(secondRow) && secondRow.equals("RRRR")) {
		    	firstRow=secondRow="OOOO";
		    }
		    String retVal= light+"\\n"+firstRow +"\\n"+ secondRow+"\\n"+ yellowString+"\\n"+forthRow;	
		    
		// if()
		    System.out.println(retVal);
		  return retVal;
		}
	
	public String padLeftZeros(String inputString, int length) {
	    if (inputString.length() >= length) {
	        return inputString;
	    }
	    StringBuilder sb = new StringBuilder();
	    while (sb.length() < length - inputString.length()) {
	        sb.append('O');
	    }
	    sb.insert(0,inputString);
	   // sb.append(inputString);

	    return sb.toString();
	}
}
