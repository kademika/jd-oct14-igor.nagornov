package lesson4.HW_Library;

public class Library {

	private final String alphabet = "АБВГДЕЖЗИКЛМНОПРСТУФХЦЧШЩЭЮЯ";
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

		booksArray[0] = new Book("Властелин колец", "Толкиен", Genre.ФЭНТАЗИ);
		booksArray[1] = new Book("Собака Баскервилей", "Конан Дойль Артур",
				Genre.ДЕТЕКТИВ);
		booksArray[2] = new Book("Зеленая миля", "Кинг Стивен", Genre.УЖАСЫ);
		booksArray[3] = new Book("Долина ужаса", "Конан Дойль Артур",
				Genre.ДЕТЕКТИВ);
		booksArray[4] = new Book("Этюд в багровых тонах", "Конан Дойль Артур",
				Genre.ДЕТЕКТИВ);
		booksArray[5] = new Book("Хоббит", "Толкиен", Genre.ФЭНТАЗИ);
		booksArray[6] = new Book("Ява-трейнер", "Файн Яков", Genre.КОМПЬЮТЕРЫ);
		booksArray[7] = new Book("Сияние", "Кинг Стивен", Genre.УЖАСЫ);
		booksArray[8] = new Book("Мобильник", "Кинг Стивен", Genre.УЖАСЫ);
		booksArray[9] = new Book("Его прощальный обет", "Конан Дойль Артур",
				Genre.ДЕТЕКТИВ);
		booksArray[10] = new Book("Знатный холостяк", "Конан Дойль Артур",
				Genre.ДЕТЕКТИВ);
		booksArray[11] = new Book("Программирование на Java", "Арнольд Кен",
				Genre.КОМПЬЮТЕРЫ);
		booksArray[12] = new Book("Пять зернышек апельсина",
				"Конан Дойль Артур", Genre.ДЕТЕКТИВ);
		booksArray[13] = new Book("Желтое лицо", "Конан Дойль Артур",
				Genre.ДЕТЕКТИВ);
		booksArray[14] = new Book("Двадцать тысяч лье под водой", "Верн Жюль",
				Genre.ПРИКЛЮЧЕНИЯ);
		booksArray[15] = new Book("История государства Российского",
				"Иванов Иван", Genre.ИСТОРИЯ);
		booksArray[16] = new Book("Таинственный остров", "Верн Жюль",
				Genre.ПРИКЛЮЧЕНИЯ);
		booksArray[17] = new Book("История великой державы", "Сидоров Сергей",
				Genre.ИСТОРИЯ);
		booksArray[18] = new Book("Хроники Нарнии", "Льюис Клайв Степлс",
				Genre.ФЭНТАЗИ);
		booksArray[19] = new Book("Гарри Поттер", "Роулинг Джоан",
				Genre.ФЭНТАЗИ);

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
						result = "По вашему запросу ничего не найдено!";
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
				System.out.println("Книг этого автора в библиотеке нет");
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
				System.out.println("Книг этого жанра в библиотеке нет");
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
