package by.htp.library.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import by.htp.library.bean.Book;
import by.htp.library.bean.Magazine;
import by.htp.library.bean.Newspaper;
import by.htp.library.bean.Print;
import by.htp.library.dao.impl.LibraryDaoImpl;

public class PrintConverter {

	private static final String DELIMETR = ";";
	public static final DateFormat DATE_FORMATTER = new SimpleDateFormat("MM/dd/yyyy");

	public static Print covertStringToPrint(String toConvert, String type) throws PrintConvertException {
		Print print = null;
		String[] values = toConvert.split(DELIMETR);
		switch (type) {
		case LibraryDaoImpl.BOOK_TYPE:
			String title = values[0];
			String author = values[1];
			int yearOfPublishing = Integer.parseInt(values[2]);
			int numberOfPages = Integer.parseInt(values[3]);
			print = new Book(title, author, yearOfPublishing, numberOfPages);
			break;
		case LibraryDaoImpl.MAGAZINE_TYPE:
			title = values[0];
			String publisher = values[1];
			numberOfPages = Integer.parseInt(values[2]);
			int editionNumber = Integer.parseInt(values[3]);
			print = new Magazine(title, publisher, numberOfPages, editionNumber);
			break;
		case LibraryDaoImpl.NEWSPAPER_TYPE:
			title = values[0];
			String publishingHouse = values[1];
			String edition = values[2];
			String startDateStr = values[3];
			Date dateRelease;
			try {
				dateRelease = DATE_FORMATTER.parse(startDateStr);
			} catch (ParseException e) {
				throw new PrintConvertException("Problem with data converting!", e);
			}
			numberOfPages = Integer.parseInt(values[4]);
			print = new Newspaper(title, publishingHouse, edition, dateRelease, numberOfPages);
			break;
		default:
			break;
		}
		return print;
	}

	public static String convertPrintToString(Print print, String type) {
		StringBuilder sb = new StringBuilder();
		switch (type) {
		case LibraryDaoImpl.BOOK_TYPE:
			Book book = (Book) print;
			sb.append(book.getTitle());
			sb.append(DELIMETR);
			sb.append(book.getAuthor());
			sb.append(DELIMETR);
			sb.append(book.getYearOfPublishing());
			sb.append(DELIMETR);
			sb.append(book.getNumberOfPages());
			break;
		case LibraryDaoImpl.MAGAZINE_TYPE:
			Magazine magazine = (Magazine) print;
			sb.append(magazine.getTitle());
			sb.append(DELIMETR);
			sb.append(magazine.getPublisher());
			sb.append(DELIMETR);
			sb.append(magazine.getNumberOfPages());
			sb.append(DELIMETR);
			sb.append(magazine.getEditionNumber());
			break;
		case LibraryDaoImpl.NEWSPAPER_TYPE:
			Newspaper newspaper = (Newspaper) print;
			sb.append(newspaper.getTitle());
			sb.append(DELIMETR);
			sb.append(newspaper.getPublishingHouse());
			sb.append(DELIMETR);
			sb.append(newspaper.getEdition());
			sb.append(DELIMETR);
			sb.append(DATE_FORMATTER.format(newspaper.getDateRelease()));
			sb.append(DELIMETR);
			sb.append(newspaper.getNumberOfPages());
			break;
		default:
			break;
		}
		return sb.toString();
	}

}
