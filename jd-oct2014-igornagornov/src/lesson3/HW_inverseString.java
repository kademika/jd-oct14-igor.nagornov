package lesson3;

public class HW_inverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "Igor Nagornov";
		System.out.println(inverse(s));
		
	}
	
	static String inverse(String str){
		if(str!=null){
		char[] mas = new char[str.length()];
		for(int i=0,j=str.length()-1; i<mas.length&&j>=0; i++, j--){
			mas[i]=str.charAt(j);
		}
		return new String(mas);	
	  }
			
		return null;
	}

}
