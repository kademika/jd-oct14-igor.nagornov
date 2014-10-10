package lesson3;

public class Video16_swap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] data1 = {0,4,6,3,5,7,6,5,3};
		int[] data2 = {1,60,5,-5,62,10,8, 48};
		
		swap(data1);
		swap(data2);
		PrintArray(data1);
		PrintArray(data2);
		
	}

	
	static void swap(int[] data){
		int temp=0;		
		if(data!=null){
			for(int i=0; i<data.length-1; i++){
				if(data[i]>data[i+1]){								
					 temp=data[i];
					 data[i]=data[i+1];
					 data[i+1]=temp;
					}					
			    }
			
		}
	}


static void PrintArray(int[] array){
	for(int s: array){			
			 System.out.print(s + " ");	
	    }								
		System.out.println();		
      }	
}
