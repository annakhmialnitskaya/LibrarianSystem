package by.htp.library.service;

import by.htp.library.bean.Library;
import by.htp.library.bean.Print;

public interface LibrarianService {

	void fillLibraryFromFile(Library library) throws LibrarianServiceException;

	void printCatalog(Library library);

	void addBook(Library library, Print book);

	void addNewspaper(Library library, Print newspaper);

	void addMagazin(Library library, Print magazin);

	void writeLibraryCatalog(Library library) throws LibrarianServiceException;

}
