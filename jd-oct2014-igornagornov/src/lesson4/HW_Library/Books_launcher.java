package lesson4.HW_Library;

import java.io.ObjectInputStream.GetField;
import java.util.Arrays;

public class Books_launcher {
	
	static Genre genre = Genre.ФЭНТАЗИ;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Books[] book = new Books[10];
		book[0] = new Books("Властелин колец", "Толкиен", Genre.ФЭНТАЗИ);		
		book[1] = new Books("Собака Баскервилей", "Артур Конан Дойль", Genre.ДЕТЕКТИВ);		
		book[2] = new Books("Зеленая миля", "Стивен Кинг", Genre.УЖАСЫ);
		book[3] = new Books("Долина ужаса", "Артур Конан Дойль", Genre.ДЕТЕКТИВ);
		book[4] = new Books("Этюд в багровых тонах", "Артур Конан Дойль", Genre.ДЕТЕКТИВ);
		book[5] = new Books("Хоббит", "Толкиен", Genre.ФЭНТАЗИ);
		book[6] = new Books("Java 24-Hour Trainer", "Yakov Faine", Genre.КОМПЬЮТЕРЫ);
		book[7] = new Books("Сияние", "Стивен Кинг", Genre.УЖАСЫ);
		book[8] = new Books("Мобильник", "Стивен Кинг", Genre.УЖАСЫ);
		book[9] = new Books("Знак четырех", "Артур Конан Дойль", Genre.ДЕТЕКТИВ);
		
		//System.out.println(Arrays.toString(genre.values()));
//		for(int i=0; i<genre.values().length; i++){
//			System.out.println(genre.values()[i]);
//		}		
		
//		genre.setId(0);
//		System.out.println(genre.genreName());
		
		sort(book);
		printLibrary(book);
		
			
	}
	

	
	public static void sort(Books[] data){
		Books temp;
						
		if(data!=null&&data.length>1){		
			for(int i=0; i<data.length-1; i++){		
				if(i<genre.values().length) genre.setId(i);				
			 for(int j=i+1; j<data.length; j++){
				if(data[i].getGenre()!=data[j].getGenre()&&data[j].getGenre()==genre.genreName()){
					
					temp=data[i];
					data[i]=data[j];
					data[j]=temp;
				}
			  }			 
		   }
		}		
		
	}
	
	
	public static void printLibrary(Books[] data){
		
		for(Books value: data){
			System.out.println(value.getName() + " " + value.getAuthor() + " " + value.getGenre());
		}
			
		
	}
}	


