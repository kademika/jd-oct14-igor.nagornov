package lesson1;

public class HW_Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "Education is the most powerful weapon which you can use to change the world";
		String t = "An investment in knowledge pays the best interest";
		
		System.out.println(s.substring(s.indexOf("use"), s.indexOf("use")+3) 
					+ " " + t.substring(t.indexOf("knowledge"), t.indexOf("knowledge") + "knowledge".length()) 
					+ " " + s.substring(s.indexOf("to")));
	}

	
}
