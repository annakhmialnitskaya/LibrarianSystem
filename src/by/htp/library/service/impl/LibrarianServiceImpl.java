package by.htp.library.service.impl;

import java.util.List;

import by.htp.library.bean.Library;
import by.htp.library.bean.Print;
import by.htp.library.dao.LibrarianDaoException;
import by.htp.library.dao.LibraryDao;
import by.htp.library.dao.impl.LibraryDaoImpl;
import by.htp.library.service.LibrarianService;
import by.htp.library.service.LibrarianServiceException;
import by.htp.library.util.PrintConvertException;

public class LibrarianServiceImpl implements LibrarianService {

	private LibraryDao dao = new LibraryDaoImpl();

	@Override
	public void fillLibraryFromFile(Library library) throws LibrarianServiceException {
		try {
			library.setBooks(dao.readInfoBooks());
			library.setMagazins(dao.readInfoMagazins());
			library.setNewspapers(dao.readInfoNewspapers());
		} catch (LibrarianDaoException | PrintConvertException e) {
			throw new LibrarianServiceException("Error with data (service layer): " + e.getMessage(), e);
		}
	}

	@Override
	public void printCatalog(Library library) {
		System.out.println("Каталог библиотеки:");
		System.out.println("   Книги:");
		for (Print book : library.getBooks()) {
			System.out.println(book);
		}
		System.out.println("   Журналы:");
		for (Print magazin : library.getMagazins()) {
			System.out.println(magazin);
		}
		System.out.println("   Газеты:");
		for (Print newspaper : library.getNewspapers()) {
			System.out.println(newspaper);
		}
	}

	@Override
	public void addBook(Library library, Print book) {
		List<Print> newBooks = library.getBooks();
		newBooks.add(book);
		library.setBooks(newBooks);
	}

	@Override
	public void addNewspaper(Library library, Print newspaper) {
		library.getNewspapers().add(newspaper);
	}

	@Override
	public void addMagazin(Library library, Print magazin) {
		library.getMagazins().add(magazin);
	}

	@Override
	public void writeLibraryCatalog(Library library) throws LibrarianServiceException {
		System.out.println("Write catalog into files...");
		try {
			dao.writeInfoBooks(library.getBooks());
			dao.writeInfoNewspapers(library.getNewspapers());
			dao.writeInfoMagazins(library.getMagazins());

			System.out.println("Writing has done");
		} catch (LibrarianDaoException e) {
			throw new LibrarianServiceException("Error with data (service layer): " + e.getMessage(), e);
		}
	}
}
