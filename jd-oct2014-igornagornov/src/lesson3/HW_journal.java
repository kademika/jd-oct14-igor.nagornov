package lesson3;

import java.util.Arrays;

public class HW_journal {
	
	static String[][] name = {{"Igor","Nagornov"},
		   {"Ivan", "Petrov"},
		   {"Grigoriy", "Sidorov"},
		   {"Valeriy", "Melnik"}};

	static String[][] subject = {{"Math", "300"},
			   {"Russian", "400"},
			   {"Geografy", "250"}};

	static int[][] journal = 
			{{0, 0, 5},
			{0, 1, 4},
			{0, 2, 3},
			{0, 3, 2},
			{1, 0, 4},
			{1, 1, 5},
			{1, 2, 2},
			{1, 3, 3},
			{2, 0, 5},
			{2, 1, 3},
			{2, 2, 4},
			{2, 3, 4}};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printJournal(journal);
	}
	
	static void printJournal(int[][] array){
		for(int i=0; i<array.length; i++){			
			  System.out.println(Arrays.toString(subject[journal[i][0]])+ " " + Arrays.toString(name[journal[i][1]]) 
					  + " " + journal[i][2]);			  
						
		}
	}	

}
