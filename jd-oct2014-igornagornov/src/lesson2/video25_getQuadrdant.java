package lesson2;

public class video25_getQuadrdant {

	static String getQuadrant(String v, String h)
	{
		String s1="abcdefghi";
		String s2="123456789";
		String result=null;
		int x,y;
		
		if(s1.contains(v)&&s2.contains(h))
		{
			x=s1.indexOf(v)*64;
			y=s2.indexOf(h)*64;
			result = x + "_" + y; 					
		}	
		return result;
		
	}
	
}
