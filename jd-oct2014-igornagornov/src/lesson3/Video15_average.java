package lesson3;

public class Video15_average {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] data1 = {1,4,6,3,5,7,6,5,3};
		int[] data2 = {1,-1,5,-5,6,8,10,22, 48};
		
		
		System.out.println(average(data1));
		System.out.println(average(data2));
		
	}
	
	static double average(int[] data){
		double ret=0;
		if(data==null||data.length==0) return -1;
		else{					
		for(int value: data){
			ret+=value;
		}
			
		return ret/=data.length;
	  }	
		
	}

}
