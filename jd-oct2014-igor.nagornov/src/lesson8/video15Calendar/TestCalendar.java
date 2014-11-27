package lesson8.video15Calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestCalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.YEAR,1988);
		calendar.set(Calendar.MONTH,0);
		calendar.set(Calendar.DAY_OF_MONTH, 31);		
	
		SimpleDateFormat formatter;		
		formatter = new SimpleDateFormat("EEEE");	
		System.out.println("I was born on " + formatter.format(calendar.getTime()));
		
	}

}
