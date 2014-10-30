package lesson4.HW_Library;

import java.util.Arrays;

public class Books_launcher {
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Library library = new Library();		
			
		library.addBookToLibrary(new Book("Побег из Шоушенка", "Кинг Стивен", Genre.УЖАСЫ));				

//		library.findBookByAuthor(library.getLibraryByAuthorName(), "Конан Дойль Артур");
// 		library.printLibrary(library.getLibraryByAuthorName());	

//		library.findBookByName(library.getLibraryByBookName(), "Побег из Шоушенка");
//		library.printLibrary(library.getLibraryByBookName());

		library.findBookByGenre(library.getLibraryByGenre(), Genre.ДЕТЕКТИВ);
//		library.printLibrary(library.getLibraryByGenre());		
			
	}	
	
}	


