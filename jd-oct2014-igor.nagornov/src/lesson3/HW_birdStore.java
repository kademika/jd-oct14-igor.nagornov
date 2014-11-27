package lesson3;

public class HW_birdStore {
						//тип птицы, количество в наличии, цена одной, сколько уже продано
	static String[][] birds = {{"eagle", "200", "100$", "100"},
					   {"duck", "2", "50$", "200"}};
	
	public static void main(String[] args) {
		
		printArray(birds);
		skolkoProdano(birds);
		skolkoVNalichii(birds);
		ostatokMensheTreh(birds);

	}
	
	static void skolkoProdano(String[][] array){
		int sum=0;
		for(int i=0; i<array.length; i++){
			sum+=Integer.parseInt(array[i][3]);	
			
		}
		System.out.println("Number of sold birds " + sum);
		
	}

    static void skolkoVNalichii(String[][] array){
    	for(int i=0; i<array.length; i++){
			System.out.println(array[i][0] + " in the stock " + array[i][1]);
		}
	}
    
    static void ostatokMensheTreh(String[][] array){
    	for(int i=0; i<array.length; i++){
			if(Integer.valueOf(array[i][1])<3) System.out.println("We need delivery of " + array[i][0] + "!");
		}
	}
    
    static void printArray(String[][] array){
		for(String[] s: array){
			for(String s1: s){
				if(s1!=null){
				 System.out.print(s1+ " ");	
				}				
			}
			System.out.println();
		}
		System.out.println();
	}
    
	
}