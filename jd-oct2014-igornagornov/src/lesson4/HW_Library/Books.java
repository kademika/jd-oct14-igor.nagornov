package lesson4.HW_Library;

public class Books {
	
	private String name;
	private String author;
	private Genre genre;
	
	Books(){
		setName("Java Trainer");
		setAuthor("Yakov Faine");
		setGenre(genre.����������);
	}
	
	Books(String name, String author, Genre genre){
		setName(name);
		setAuthor(author);
		setGenre(genre);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	

}
