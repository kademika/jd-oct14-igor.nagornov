package lesson3;

import java.util.Arrays;

public class Video27_union {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] data1 = {1,4,3,2,1,3,5};
		int [] data2 = {0,3,2,1};
		System.out.println(Arrays.toString(union(data1,data2)));
		
	}
	
	static int[] union(int[] data1, int[] data2){
		int[] union = new int [data1.length + data2.length];
		
		for(int i=0, j=0; i<(data1.length + data2.length); i++){			
			if(i<data1.length) union[i]=data1[i];
			else {
				  union[i]=data2[j];
				  j++;			
			}
		}		
		return union;
	}

}
