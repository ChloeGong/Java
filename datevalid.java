package HCMM17S1;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class datevalid {
	private static SimpleDateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy");//输出格式
	private String birthday;
	private Date date;
	public datevalid(String birthday){//String birthday;
		String[]tempbr;
		dateformat.setLenient(false);
		this.birthday=birthday; 
		if (birthday.matches("(\\d){1,2}-(\\d){1,2}-(\\d)+{4}")||birthday.matches("(\\d){1,2}/(\\d){1,2}/(\\d)+{4}")) {
			   tempbr = birthday.split("\\D");//以非数字为隔断；
			   //int day = Integer.parseInt(tempbr[0]);
				//int month = Integer.parseInt(tempbr[1]);
				 //int year = Integer.parseInt(tempbr[2]);
			if(tempbr.length == 3) { 	
				for (int j = 0; j < 2; j++) {
					if (tempbr[j].length() < 2)
						tempbr[j] = "0" + tempbr[j];
					}
					/*if (month<=0||month>=13) 
						date=null;
					   else {
					        int[] monthLength =
								new int[] {0, 31, -1, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
						         if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
							     monthLength[2] = 29;
					            	} 
						         else {
							     monthLength[2] = 28;
							     }
							     int dayLength = monthLength[month];
						         if (day < 1 || day > dayLength) {
							   date=null;}
							   else*/
						     birthday = tempbr[0] + "/" + tempbr[1] + "/" + tempbr[2];
						        
						}
				}
				
			//	}
        try{
        	dateformat.setLenient(false);
        	date=dateformat.parse(birthday);
        	Date today=new Date();
        	if(today.before(date))
        		date=null;
        	}
 		  catch(ParseException e){
				date=null;
			}
			}
		
	
public boolean isValid(){
		if(date!=null){
			return true;
		}
		else return false;
	}

public String toString(){
	return dateformat.format(date);
	}
public Date getDate(){
	return date;
}
}
