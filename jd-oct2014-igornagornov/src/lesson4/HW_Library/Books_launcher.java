package lesson4.HW_Library;

import java.util.Arrays;

public class Books_launcher {
	
	private static Genre genre = Genre.ФЭНТАЗИ;
	private static final String alphabet="АБВГДЕЖЗИКЛМНОПРСТУФХЦЧШЩЭЮЯ";
	private static Books[][] libraryByAuthorName = new Books[alphabet.length()][];
	private static Books[][] libraryByBookName = new Books[alphabet.length()][];
	private static Books[][] libraryByGenre = new Books[6][];
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Books[] books = createLibrary();	
		addBookToLibrary(books, new Books("Худеющий", "Кинг Стивен", Genre.УЖАСЫ));
		
		//sortByGenre(books);			
		
//		fillLibraryByAuthor(books);
//		findBookByAuthor(libraryByAuthorName, "Конан Дойль Артур");
// 		printLibrary(libraryByAuthorName);
			
//		fillLibraryByBookName(books);
//		findBookByName(libraryByBookName, "Худеющий");
//		printLibrary(libraryByBookName);
		
		fillLibraryByGenre(books);
		findBookByGenre(libraryByGenre, Genre.ДЕТЕКТИВ);
		//printLibrary(libraryByGenre);	
		
			
	}
	

	public static Books[] createLibrary(){
		
		Books[] book = new Books[100];
		book[0] = new Books("Властелин колец", "Толкиен", Genre.ФЭНТАЗИ);		
		book[1] = new Books("Собака Баскервилей", "Конан Дойль Артур", Genre.ДЕТЕКТИВ);		
		book[2] = new Books("Зеленая миля", "Кинг Стивен", Genre.УЖАСЫ);
		book[3] = new Books("Долина ужаса", "Конан Дойль Артур", Genre.ДЕТЕКТИВ);
		book[4] = new Books("Этюд в багровых тонах", "Конан Дойль Артур", Genre.ДЕТЕКТИВ);
		book[5] = new Books("Хоббит", "Толкиен", Genre.ФЭНТАЗИ);
		book[6] = new Books("Ява-трейнер", "Файн Яков", Genre.КОМПЬЮТЕРЫ);
		book[7] = new Books("Сияние", "Кинг Стивен", Genre.УЖАСЫ);
		book[8] = new Books("Мобильник", "Кинг Стивен", Genre.УЖАСЫ);
		book[9] = new Books("Его прощальный обет", "Конан Дойль Артур", Genre.ДЕТЕКТИВ);
		book[10] = new Books("Знатный холостяк", "Конан Дойль Артур", Genre.ДЕТЕКТИВ);
		book[11] = new Books("Программирование на Java", "Арнольд Кен", Genre.КОМПЬЮТЕРЫ);
		book[12] = new Books("Пять зернышек апельсина", "Конан Дойль Артур", Genre.ДЕТЕКТИВ);
		book[13] = new Books("Желтое лицо", "Конан Дойль Артур", Genre.ДЕТЕКТИВ);
		book[14] = new Books("Двадцать тысяч лье под водой", "Верн Жюль", Genre.ПРИКЛЮЧЕНИЯ);
		book[15] = new Books("История государства Российского", "Иванов Иван", Genre.ИСТОРИЯ);
		book[16] = new Books("Таинственный остров", "Верн Жюль", Genre.ПРИКЛЮЧЕНИЯ);
		book[17] = new Books("История великой державы", "Сидоров Сергей", Genre.ИСТОРИЯ);
		book[18] = new Books("Хроники Нарнии", "Льюис Клайв Степлс", Genre.ФЭНТАЗИ);
		book[19] = new Books("Гарри Поттер", "Роулинг Джоан", Genre.ФЭНТАЗИ);
		
		return book;		
		
	}
	
	public static void fillLibraryByAuthor(Books[] data) throws Exception{		
		
		String[] authors=getAuthor(data);	
		for(int j=0; authors[j]!=null; j++){		
		
		int i=getNumberOfElements(libraryByAuthorName[alphabet.indexOf(authors[j].charAt(0))]);;
				
		if(data!=null){
			for(Books value: data){
				if(value!=null){
				
					if(value.getAuthor().equals(authors[j])&&(alphabet.indexOf(authors[j].charAt(0))!=-1)){
						
						if(i==0){
							libraryByAuthorName[alphabet.indexOf(authors[j].charAt(0))] = new Books[data.length];				
						}
						
						libraryByAuthorName[alphabet.indexOf(authors[j].charAt(0))][i]=value;					
						i++;
					}					
				  }	
				}								
			  }	
			}
		
		}	
	
	public static void fillLibraryByGenre(Books[] data){				
 		
		if(data!=null){
			
			for(Books value: data){					
				if(value!=null){					
						if(libraryByGenre[value.getGenre().getId()]==null){
							libraryByGenre[value.getGenre().getId()] = new Books[data.length];
							
						}						
							int number=getNumberOfElements(libraryByGenre[value.getGenre().getId()]);
							libraryByGenre[value.getGenre().getId()][number]=value;	
					}					
				}	
			}	
		
	}
	
	public static void fillLibraryByBookName(Books[] data) throws Exception{		
	
		
		if(data!=null){
			for(Books value: data){					
				if(value!=null&&(alphabet.indexOf(value.getName().charAt(0))!=-1)){					
						if(libraryByBookName[alphabet.indexOf(value.getName().charAt(0))]==null){
							libraryByBookName[alphabet.indexOf(value.getName().charAt(0))] = new Books[data.length];
							
						}
						
							int number=getNumberOfElements(libraryByBookName[alphabet.indexOf(value.getName().charAt(0))]);
							libraryByBookName[alphabet.indexOf(value.getName().charAt(0))][number]=value;				
							
					}					
				}	
			}	
				
	}
	
	public static void addBookToLibrary(Books[] data, Books book){		
		
		if(data!=null){			
				data[getNumberOfElements(data)]=book;
			}		
		
	}
		
	
	public static void printLibrary(Books[][] data) throws Exception{
		
		int count=0;
		
		if(data!=null){
			for(Books[] valueV: data){
				if(valueV!=null){
					for(Books valueH: valueV){
						if(valueH!=null) {
							count++;
							System.out.println(count + ": " + valueH.getName() + " " + valueH.getAuthor() + " " + valueH.getGenre());	
						}					
					}	
				}				
			}	
		}			
		
	}
	
	public static int getNumberOfElements(Books[] data){
		int number=0;
		if(data!=null){
			for(Books value: data){
				if(value!=null){
					number++;
				}
			}	
		}	
		return number;
		
	}
	
	public static String[] getAuthor(Books[] data){
				
		String[] authorNames = new String[data.length];
		if(data!=null){
			int i=0;
			authorNames[0]=data[0].getAuthor();
			for(Books value: data){
				if(value!=null){
					if(!value.getAuthor().equals(authorNames[i])){
						boolean flag=false;
						for(int j=0; j<authorNames.length&&authorNames[j]!=null; j++){
							if(authorNames[j]==value.getAuthor()) {
								flag=true;
								break;							
							}
						}
						if(!flag){						
							i++;
							authorNames[i]=value.getAuthor();	
						}
						
					}
					
				}
			}	
		}	
		return authorNames;		
		
	} 	
	
	public static void findBookByName(Books[][] data, String name) throws Exception{
		String result=null;
		if(data!=null&&data[alphabet.indexOf(name.charAt(0))]!=null){
			for(Books value: data[alphabet.indexOf(name.charAt(0))]){
				if(value!=null){				
					if(value.getName().equals(name)){
						result=value.getName() + " " + value.getAuthor() + " " + value.getGenre();
						break;
					}
					else result="По вашему запросу ничего не найдено!";		
				}
					
			}	
			
			System.out.println(result);	
		}
		
	}
	
	public static void findBookByAuthor(Books[][] data, String name) throws Exception{
				
		int k=0;
		if(data!=null&&data[alphabet.indexOf(name.charAt(0))]!=null){
			for(Books value: data[alphabet.indexOf(name.charAt(0))]){
				if(value!=null){				
					if(value.getAuthor().equals(name)){
						System.out.println((k+1) + ": " + value.getName() + " " + value.getAuthor() + " " + value.getGenre());
						k++;
					}						
				}
					
			}	
			
			if(k==0){
				System.out.println("Книг этого автора в библиотеке нет");
			}	
		}
		
	}
	
	public static void findBookByGenre(Books[][] data, Genre genre) throws Exception{
		
		int k=0;
		if(data!=null&&data[genre.getId()]!=null){
			for(Books value: data[genre.getId()]){
				if(value!=null){				
					if(value.getGenre().equals(genre)){
						System.out.println((k+1) + ": " + value.getName() + " " + value.getAuthor() + " " + value.getGenre());
						k++;
					}						
				}
					
			}	
			
			if(k==0){
				System.out.println("Книг этого жанра в библиотеке нет");
			}	
		}
		
	}
	
//	public static void sortByGenre(Books[] data) throws Exception{
// 		Books temp;
// 		int genreCount=0;
// 		int sum=0;		
// 						
// 		if(data!=null&&data.length>1){	
// 			while(genreCount<genre.values().length){
// 				genre.setId(genreCount);
// 				for(int i=sum; i<data.length-1; i++){	
// 					if(data[i].getGenre()== genre.genreName()) sum++;
// 					 for(int j=i+1; j<data.length; j++){						
// 						if(data[i].getGenre()!=data[j].getGenre()&&data[j].getGenre()== genre.genreName()){							
// 							temp=data[i];
// 							data[i]=data[j];
// 							data[j]=temp;	
//  							sum++;							
// 						}
// 					  }						
// 				   }
// 				genreCount++;
// 				
// 			}
// 			
// 		}		
// 		
// 	}
	


}	


