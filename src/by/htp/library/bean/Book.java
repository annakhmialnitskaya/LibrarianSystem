package by.htp.library.bean;

public class Book extends Print {

	private String author;
	private int yearOfPublishing;

	public Book(String title, String author, int yearOfPublishing,int numberOfPages) {
		super(title, numberOfPages);
		this.author = author;
		this.yearOfPublishing = yearOfPublishing;
	}

	public String getAuthor() {
		return author;
	}

	public int getYearOfPublishing() {
		return yearOfPublishing;
	}

	@Override
	public String toString() {
		return " Название: " + getTitle() + " Автор: " + author + " Год выпуска: " + yearOfPublishing
				+ " Количество страниц: " + getNumberOfPages();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + yearOfPublishing;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (yearOfPublishing != other.yearOfPublishing)
			return false;
		return true;
	}
}
