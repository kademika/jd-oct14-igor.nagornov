package lesson4.HW_Library;

import java.util.Arrays;

public class Books_launcher {
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Library library = new Library();		
			
		library.addBookToLibrary(new Book("Escape from Shoushenk", "King Steven", Genre.HORRORS));				

//		library.findBookByAuthor(library.getLibraryByAuthorName(), "Conan Doyle Artur");
// 		library.printLibrary(library.getLibraryByAuthorName());	

//		library.findBookByName(library.getLibraryByBookName(), "Escape from Shoushenk");
//		library.printLibrary(library.getLibraryByBookName());
//
		library.findBookByGenre(library.getLibraryByGenre(), Genre.DETECTIVE);
//		library.printLibrary(library.getLibraryByGenre());		
			
	}	
	
}	


