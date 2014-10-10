package lesson3;

public class Video6_getLast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr1 = {0,4,3,5,6};
		int[] arr2 = {-2,4,3,6,7,65,5,8,9};
		int[] arr3 = {};
		int[] arr4 = {0};
		
		System.out.println(getLast(arr1));
		System.out.println(getLast(arr2));
		System.out.println(getLast(arr3));
		System.out.println(getLast(arr4));
				
	}
	
	static int getLast(int[] data){
		if(data.length>0){
			return data[data.length-1];		
		}
		
		return -1;		
	}
}
