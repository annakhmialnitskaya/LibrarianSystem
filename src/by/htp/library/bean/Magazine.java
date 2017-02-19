package by.htp.library.bean;

public class Magazine extends Print {

	private String publisher;
	private int editionNumber;

	public Magazine(String title, String publisher ,int numberOfPages, int editionNumber) {
		super(title, numberOfPages);
		this.publisher = publisher;
		this.editionNumber = editionNumber;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getEditionNumber() {
		return editionNumber;
	}

	@Override
	public String toString() {
		return " Название: " + getTitle() + " Издатель: " + publisher + " Номер издания: " + editionNumber
				+ " Количество страниц: " + getNumberOfPages();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + editionNumber;
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
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
		Magazine other = (Magazine) obj;
		if (editionNumber != other.editionNumber)
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		return true;
	}
}
