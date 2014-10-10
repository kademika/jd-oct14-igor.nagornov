package lesson3;

public class Video13_addElementSum {
	public static void main(String[] arg){
		int[] data1 = {1,4,6,3,5,7,6,5,3};
		int[] data2 = {1,-1,5,-5,6,8,10,22, 48};
		
		
		System.out.println(sumNechet(data1));
		System.out.println(sumNechet(data2));
	}
	
	static int sumNechet(int[] data){
		int sum=0;
		if(data==null){
			return -1;
		}
		else for(int i=0; i<data.length; i++){
			if(i%2!=0){
			 sum+=data[i];	
			}
		}
		
		return sum;
	}
	

}
