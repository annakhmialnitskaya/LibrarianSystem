package by.htp.library.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import by.htp.library.bean.Print;
import by.htp.library.dao.LibrarianDaoException;
import by.htp.library.dao.LibraryDao;
import by.htp.library.util.PrintConvertException;
import by.htp.library.util.PrintConverter;

public class LibraryDaoImpl implements LibraryDao {

	private static final String BOOKS_FILENAME = "books.txt";
	private static final String MAGAZINES_FILENAME = "magazines.txt";
	private static final String NEWSPAPERS_FILENAME = "newspapers.txt";

	public static final String BOOK_TYPE = "book";
	public static final String MAGAZINE_TYPE = "magazine";
	public static final String NEWSPAPER_TYPE = "newspaper";

	@Override
	public List<Print> readInfoBooks() throws LibrarianDaoException, PrintConvertException {
		return readInfo(BOOKS_FILENAME, BOOK_TYPE);
	}

	@Override
	public List<Print> readInfoNewspapers() throws LibrarianDaoException, PrintConvertException {
		return readInfo(NEWSPAPERS_FILENAME, NEWSPAPER_TYPE);
	}

	@Override
	public List<Print> readInfoMagazins() throws LibrarianDaoException, PrintConvertException {
		return readInfo(MAGAZINES_FILENAME, MAGAZINE_TYPE);
	}

	@Override
	public void writeInfoBooks(List<Print> list) throws LibrarianDaoException {
		writeInfo(list, BOOKS_FILENAME, BOOK_TYPE);
	}

	@Override
	public void writeInfoNewspapers(List<Print> list) throws LibrarianDaoException {
		writeInfo(list, NEWSPAPERS_FILENAME, NEWSPAPER_TYPE);
	}

	@Override
	public void writeInfoMagazins(List<Print> list) throws LibrarianDaoException {
		writeInfo(list, MAGAZINES_FILENAME, MAGAZINE_TYPE);
	}

	private List<Print> readInfo(String path, String type) throws LibrarianDaoException, PrintConvertException {
		List<Print> result = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(new File(getClass().getClassLoader().getResource(path).getFile()))))) {
			String line;
			Print print;
			while ((line = br.readLine()) != null) {
				print = PrintConverter.covertStringToPrint(line, type);
				result.add(print);
			}
		} catch (IOException e) {
			throw new LibrarianDaoException("Reading: there is problem with data file (dao layer)", e);
		}
		return result;
	}

	private void writeInfo(List<Print> list, String path, String type) throws LibrarianDaoException {
		try (FileWriter writer = new FileWriter("d:/" + path, false)) {
			String s;
			for (Print print : list) {
				s = PrintConverter.convertPrintToString(print, type);
				writer.write(s);
				writer.append('\n');
			}
			writer.flush();
		} catch (IOException e) {
			throw new LibrarianDaoException("Writing: there is problem with data file (dao layer)", e);
		}
	}
}
