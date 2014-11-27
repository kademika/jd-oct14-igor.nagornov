package lesson3;

import java.util.Arrays;

public class Video26_Country {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			String data[][] = {{"China", "Pekin", "1354040000"},
					{"India", "Deli", "1210569573"},
					{"USA", "Washington", "316305000"},
					{"Indonesia", "Jakarta", "237641326"},
					{"Brasil", "Rio", "193946886"},
					{"Pakistan", "Islamabad", "183748060"}};
					
			System.out.println(getPopulation(data));			

		}
		
		static long getPopulation(String[][] data){
			long value=0;
			for(int i=0; i<data.length; i++){
				value+=Long.parseLong(data[i][2]);			
			}
			return value;
		}	
		
}


