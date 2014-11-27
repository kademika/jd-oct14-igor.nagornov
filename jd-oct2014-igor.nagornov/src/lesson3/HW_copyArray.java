package lesson3;

import java.util.Arrays;

public class HW_copyArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] data1 = {11,24,32,23,57,55,66,77};	
		int[] data2 = {3,1,2,-2,-4,5,4,6,7,8,9};
		//copyArray(data1, 2, data2, 2, 4);
		System.arraycopy(data1, 2, data2, 2, 4);
		System.out.println(Arrays.toString(data2));
		
	}
	
	static void copyArray(int[] src, int srcPos, int[] dst, int dstPos, int length){
		if(src!=null&&dst!=null){
			for(int i=dstPos; i<dstPos+length; i++){
				dst[i]=src[srcPos++];
			}
		}	
	}

}
