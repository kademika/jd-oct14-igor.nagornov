package lesson8.video13Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HappyBirthday {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		Date today;
		String output;
		SimpleDateFormat formatter;
		
		formatter = new SimpleDateFormat("dd MMM yyyy");
		today = new Date(88, 0, 31, 20, 10, 0); //year-1900, month, day, hour, minute, second
		output = formatter.format(today);
		System.out.println(today + " by default");
		System.out.println(output + " after formatter");
		System.out.println(formatter.parse(output) + " after formatter parse"); //rashiryaet format do polnogo
		
	}

}
