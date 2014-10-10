package lesson2;

public class video25_printCoordinates {

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
	
	static void printCoordinates(String v, String h){
		String result;
		
		result=getQuadrant(v,h);		
		System.out.println(v + h + ":(" + result.substring(0, result.indexOf("_")) + "px; "  
			+ result.substring(result.indexOf("_")+1) + "px;)");
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printCoordinates("a", "4");
		printCoordinates("f", "7");
		printCoordinates("d", "8");
		printCoordinates("g", "3");
		
	}

	
}
