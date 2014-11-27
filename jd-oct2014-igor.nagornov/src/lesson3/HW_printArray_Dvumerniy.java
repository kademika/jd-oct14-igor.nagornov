package lesson3;

import java.util.Arrays;

public class HW_printArray_Dvumerniy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[][] arr = {{"1","2","3",},{"4","5"},{"6","7","8","9"},{"10","11","12", "13", "14"}}; 	

		PrintArray(arr);
		PrintArray2(arr);
	}

	static void PrintArray(String[][] array){
		 for(int i=0; i<array.length; i++){
			if(i==0) System.out.print('[');		
			if(i>=0&&i<array.length-1) System.out.print(Arrays.toString(array[i])+','); 
			if(i==array.length-1) {			
				System.out.print(Arrays.toString(array[i])); 
				System.out.print("]\n");
			}
		 }		
			
		}
		
		static void PrintArray2(String[][] array){
			for(String[] s: array){
				for(String s1: s){
					if(s1!=null){
					 System.out.print(s1+ " ");	
					}				
				}
				System.out.println();
			}
		}	
}
