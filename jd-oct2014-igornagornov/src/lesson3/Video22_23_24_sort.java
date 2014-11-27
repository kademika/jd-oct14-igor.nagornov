package lesson3;
import java.util.Arrays;
import java.util.Random;


public class Video22_23_24_sort {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data1 = createArray(100000);
		int[] data2 = createRArray(100000);		
		int[] data3 = createArray(100000);
		int[] data4 = createRArray(100000);			
		
//		sort(data1);
//		sort(data2);	
//		
//		sort2(data3);
//		sort2(data4);
		
		long time = System.currentTimeMillis();
		Arrays.sort(data2);
		System.out.println(System.currentTimeMillis() - time);
		System.out.println(Arrays.toString(data2));
		
	
//		System.out.println(Arrays.toString(data2));		
//		System.out.println(Arrays.toString(data4));
		
		
}	

	
	static void swap(int[] data, int i, int k){
		int temp=0;
		if(i<k&&i>=0&&k<data.length){
			if(data[i]>data[k]){								
				 temp=data[k];
				 data[k]=data[i];
				 data[i]=temp;
				}	
	}
	}
	
	static void sort2(int[] data){
		int temp=0;
		long time=System.currentTimeMillis();
		if(data!=null&&data.length>1){//			
			for(int i=0; i<data.length-1; i++){		
			 for(int j=i+1; j<data.length; j++){
				if(data[i]>data[j]){
					temp=data[i];
					data[i]=data[j];
					data[j]=temp;
				}
			  }			 
		   }
		}
		System.out.println(System.currentTimeMillis() - time);
		
	}
	
	static void sort(int[] data){
		long time = System.currentTimeMillis();
		if(data!=null){
			int activeLength = data.length-1;
			for(int i=0; i <data.length; i++){
				for(int k=0; k <activeLength; k++){
					swap(data, k, k+1);
				}
				activeLength--;
			}			
		}
		System.out.println(System.currentTimeMillis() - time);		
	}

	
	static int[] createArray(int size){
		
		int[] Array = new int [size];
		
		for(int i=0; i<Array.length; i++){
			Array[i]=size--;
		}
		
		return Array;		
		
	}
	
	static int[] createRArray(int size){
		
		int[] Array = new int [size];
		Random r = new Random();
		
		for(int i=0; i<Array.length; i++){
			Array[i]=r.nextInt(Array.length);
		}
		
		return Array;		
		
	}
	
}