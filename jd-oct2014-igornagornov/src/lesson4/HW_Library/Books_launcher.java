package lesson4.HW_Library;

import java.util.Arrays;

public class Books_launcher {
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Library library = new Library();		
			
		library.addBookToLibrary(new Book("����� �� ��������", "���� ������", Genre.�����));				

//		library.findBookByAuthor(library.getLibraryByAuthorName(), "����� ����� �����");
// 		library.printLibrary(library.getLibraryByAuthorName());	

//		library.findBookByName(library.getLibraryByBookName(), "����� �� ��������");
//		library.printLibrary(library.getLibraryByBookName());

		library.findBookByGenre(library.getLibraryByGenre(), Genre.��������);
//		library.printLibrary(library.getLibraryByGenre());		
			
	}	
	
}	


