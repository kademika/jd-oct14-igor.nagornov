package lesson3;

public class Video9_printArray {
	
	public static void main(String[] arg){
		String[] arr = {"1", "2345", "678", "9"};
		PrintArray(arr);
	}
	
	static void PrintArray(String[] array){
		for(String s: array){			
				 System.out.print(s + " ");	
		    }								
			System.out.println();		
	      }	
	
}
