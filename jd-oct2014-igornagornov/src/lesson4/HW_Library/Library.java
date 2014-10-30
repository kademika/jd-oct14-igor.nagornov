package lesson4.HW_Library;

public class Library {

	private final String alphabet = "����������������������������";
	private Book[][] libraryByAuthorName = new Book[alphabet.length()][];
	private Book[][] libraryByBookName = new Book[alphabet.length()][];
	private Book[][] libraryByGenre = new Book[6][];
	private Book[] booksArray = new Book[100];

	public Library() throws Exception {
		// TODO Auto-generated constructor stub
		createLibrary();
		fillLibraryByAuthor(booksArray);
		fillLibraryByBookName(booksArray);
		fillLibraryByGenre(booksArray);

	}

	public Book[] createLibrary() {

		booksArray[0] = new Book("��������� �����", "�������", Genre.�������);
		booksArray[1] = new Book("������ �����������", "����� ����� �����",
				Genre.��������);
		booksArray[2] = new Book("������� ����", "���� ������", Genre.�����);
		booksArray[3] = new Book("������ �����", "����� ����� �����",
				Genre.��������);
		booksArray[4] = new Book("���� � �������� �����", "����� ����� �����",
				Genre.��������);
		booksArray[5] = new Book("������", "�������", Genre.�������);
		booksArray[6] = new Book("���-�������", "���� ����", Genre.����������);
		booksArray[7] = new Book("������", "���� ������", Genre.�����);
		booksArray[8] = new Book("���������", "���� ������", Genre.�����);
		booksArray[9] = new Book("��� ���������� ����", "����� ����� �����",
				Genre.��������);
		booksArray[10] = new Book("������� ��������", "����� ����� �����",
				Genre.��������);
		booksArray[11] = new Book("���������������� �� Java", "������� ���",
				Genre.����������);
		booksArray[12] = new Book("���� �������� ���������",
				"����� ����� �����", Genre.��������);
		booksArray[13] = new Book("������ ����", "����� ����� �����",
				Genre.��������);
		booksArray[14] = new Book("�������� ����� ��� ��� �����", "���� ����",
				Genre.�����������);
		booksArray[15] = new Book("������� ����������� �����������",
				"������ ����", Genre.�������);
		booksArray[16] = new Book("������������ ������", "���� ����",
				Genre.�����������);
		booksArray[17] = new Book("������� ������� �������", "������� ������",
				Genre.�������);
		booksArray[18] = new Book("������� ������", "����� ����� ������",
				Genre.�������);
		booksArray[19] = new Book("����� ������", "������� �����",
				Genre.�������);

		return booksArray;

	}

	public void fillLibraryByAuthor(Book[] book) throws Exception {

		String[] author = getAuthor(book);
		for (int j = 0; author[j] != null; j++) {

			int i = getNumberOfElements(libraryByAuthorName[alphabet
					.indexOf(author[j].charAt(0))]);

			for (Book bookTemp : book) {
				if (bookTemp != null) {

					if (bookTemp.getAuthor().equals(author[j])
							&& (alphabet.indexOf(author[j].charAt(0)) != -1)) {

						if (i == 0) {
							libraryByAuthorName[alphabet.indexOf(author[j]
									.charAt(0))] = new Book[book.length];
						}

						libraryByAuthorName[alphabet.indexOf(author[j]
								.charAt(0))][i] = bookTemp;
						i++;
					}
				}
			}
		}

	}

	public void fillLibraryByBookName(Book[] book) throws Exception {

		for (Book bookTemp : book) {
			if (bookTemp != null
					&& (alphabet.indexOf(bookTemp.getName().charAt(0)) != -1)) {
				if (libraryByBookName[alphabet.indexOf(bookTemp.getName()
						.charAt(0))] == null) {
					libraryByBookName[alphabet.indexOf(bookTemp.getName()
							.charAt(0))] = new Book[book.length];

				}

				int number = getNumberOfElements(libraryByBookName[alphabet
						.indexOf(bookTemp.getName().charAt(0))]);
				libraryByBookName[alphabet
						.indexOf(bookTemp.getName().charAt(0))][number] = bookTemp;

			}
		}

	}

	public void fillLibraryByGenre(Book[] book) {

		for (Book bookTemp : book) {
			if (bookTemp != null) {
				if (libraryByGenre[bookTemp.getGenre().getId()] == null) {
					libraryByGenre[bookTemp.getGenre().getId()] = new Book[book.length];

				}
				int number = getNumberOfElements(libraryByGenre[bookTemp
						.getGenre().getId()]);
				libraryByGenre[bookTemp.getGenre().getId()][number] = bookTemp;
			}
		}

	}

	public void addBookToLibrary(Book book) {

		booksArray[getNumberOfElements(booksArray)] = book;

		int iAuthor = alphabet.indexOf(book.getAuthor().charAt(0));
		int jAuthor = getNumberOfElements(libraryByAuthorName[iAuthor]);
		if (libraryByAuthorName[iAuthor] == null) {
			libraryByAuthorName[iAuthor] = new Book[booksArray.length];

		}
		libraryByAuthorName[iAuthor][jAuthor] = book;

		int iBookName = alphabet.indexOf(book.getName().charAt(0));
		int jBookName = getNumberOfElements(libraryByBookName[iBookName]);
		if (libraryByBookName[iBookName] == null) {
			libraryByBookName[iBookName] = new Book[booksArray.length];

		}
		libraryByBookName[iBookName][jBookName] = book;

		int iGenre = book.getGenre().getId();
		int jGenre = getNumberOfElements(libraryByGenre[iGenre]);
		if (libraryByGenre[iGenre] == null) {
			libraryByGenre[iGenre] = new Book[booksArray.length];

		}
		libraryByGenre[iGenre][jGenre] = book;

	}

	public void printLibrary(Book[][] bookArray) throws Exception {

		int count = 0;

		for (Book[] shelf : bookArray) {
			if (shelf != null) {
				for (Book book : shelf) {
					if (book != null) {
						count++;
						System.out.println(count + ": " + book.getName() + " "
								+ book.getAuthor() + " " + book.getGenre());
					}
				}
			}
		}

	}

	public int getNumberOfElements(Book[] booksArray) {
		int number = 0;

		if (booksArray != null) {
			for (Book BookTemp : booksArray) {
				if (BookTemp != null) {
					number++;
				}
			}

		}

		return number;

	}

	public String[] getAuthor(Book[] booksArray) {

		String[] authorNames = new String[booksArray.length];

		int i = 0;
		authorNames[0] = booksArray[0].getAuthor();
		for (Book bookTemp : booksArray) {
			if (bookTemp != null) {
				if (!bookTemp.getAuthor().equals(authorNames[i])) {
					boolean flag = false;
					for (int j = 0; j < authorNames.length
							&& authorNames[j] != null; j++) {
						if (authorNames[j] == bookTemp.getAuthor()) {
							flag = true;
							break;
						}
					}
					if (!flag) {
						i++;
						authorNames[i] = bookTemp.getAuthor();
					}

				}

			}

		}
		return authorNames;

	}

	public void findBookByName(Book[][] bookArray, String bookName)
			throws Exception {
		String result = null;
		if (bookArray != null
				&& bookArray[alphabet.indexOf(bookName.charAt(0))] != null) {
			for (Book bookTemp : bookArray[alphabet.indexOf(bookName.charAt(0))]) {
				if (bookTemp != null) {
					if (bookTemp.getName().equals(bookName)) {
						result = bookTemp.getName() + " "
								+ bookTemp.getAuthor() + " "
								+ bookTemp.getGenre();
						break;
					} else
						result = "�� ������ ������� ������ �� �������!";
				}

			}

			System.out.println(result);
		}

	}

	public void findBookByAuthor(Book[][] bookArray, String authorName)
			throws Exception {

		int k = 0;
		if (bookArray != null
				&& bookArray[alphabet.indexOf(authorName.charAt(0))] != null) {
			for (Book bookTemp : bookArray[alphabet.indexOf(authorName
					.charAt(0))]) {
				if (bookTemp != null) {
					if (bookTemp.getAuthor().equals(authorName)) {
						System.out.println((k + 1) + ": " + bookTemp.getName()
								+ " " + bookTemp.getAuthor() + " "
								+ bookTemp.getGenre());
						k++;
					}
				}

			}

			if (k == 0) {
				System.out.println("���� ����� ������ � ���������� ���");
			}
		}

	}

	public void findBookByGenre(Book[][] bookArray, Genre genre)
			throws Exception {

		int k = 0;
		if (bookArray != null && bookArray[genre.getId()] != null) {
			for (Book bookTemp : bookArray[genre.getId()]) {
				if (bookTemp != null) {
					if (bookTemp.getGenre().equals(genre)) {
						System.out.println((k + 1) + ": " + bookTemp.getName()
								+ " " + bookTemp.getAuthor() + " "
								+ bookTemp.getGenre());
						k++;
					}
				}

			}

			if (k == 0) {
				System.out.println("���� ����� ����� � ���������� ���");
			}
		}

	}

	public Book[][] getLibraryByAuthorName() {
		return libraryByAuthorName;
	}

	public Book[][] getLibraryByBookName() {
		return libraryByBookName;
	}

	public Book[][] getLibraryByGenre() {
		return libraryByGenre;
	}

}
