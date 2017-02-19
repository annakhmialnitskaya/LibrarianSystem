package by.htp.library.bean;

import java.util.Date;

import by.htp.library.util.PrintConverter;

public class Newspaper extends Print {

	private String publishingHouse;
	private String edition;
	private Date dateRelease;

	public Newspaper(String title, String publishingHouse, String edition, Date dateRelease, int numberOfPages) {
		super(title, numberOfPages);
		this.publishingHouse = publishingHouse;
		this.edition = edition;
		this.dateRelease = dateRelease;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public String getEdition() {
		return edition;
	}

	public Date getDateRelease() {
		return dateRelease;
	}

	@Override
	public String toString() {
		return " Название: " + getTitle() + " Издательство: " + publishingHouse + "Тираж: " + edition
				+ " Дата выпуска: " + PrintConverter.DATE_FORMATTER.format(dateRelease) + " Количество страниц: "
				+ getNumberOfPages();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateRelease == null) ? 0 : dateRelease.hashCode());
		result = prime * result + ((edition == null) ? 0 : edition.hashCode());
		result = prime * result + ((publishingHouse == null) ? 0 : publishingHouse.hashCode());
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
		Newspaper other = (Newspaper) obj;
		if (dateRelease == null) {
			if (other.dateRelease != null)
				return false;
		} else if (!dateRelease.equals(other.dateRelease))
			return false;
		if (edition == null) {
			if (other.edition != null)
				return false;
		} else if (!edition.equals(other.edition))
			return false;
		if (publishingHouse == null) {
			if (other.publishingHouse != null)
				return false;
		} else if (!publishingHouse.equals(other.publishingHouse))
			return false;
		return true;
	}
}
