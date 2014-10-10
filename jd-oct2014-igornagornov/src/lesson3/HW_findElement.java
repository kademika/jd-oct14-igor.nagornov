package lesson3;

public class HW_findElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double[] data1 = {1.1,2.4,3.2,2.3,5,7};	
		double[] data2 = {1.3,1.55,10.1,-2,-2.4};	
		System.out.println(findElement(data1, 2.3));
		System.out.println(findElement(data2, -2.4));
	}

	static int findElement(double[] data, double el){
		if(data!=null){
		for(int i=0; i<data.length; i++){
			if(data[i] == el) return i;
		}
	  }	
		return -1;
	}	 
	
}
