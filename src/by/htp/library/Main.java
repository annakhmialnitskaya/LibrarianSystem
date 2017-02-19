package by.htp.library;

import by.htp.library.bean.Book;
import by.htp.library.bean.Library;
import by.htp.library.bean.Print;
import by.htp.library.service.LibrarianService;
import by.htp.library.service.LibrarianServiceException;
import by.htp.library.service.impl.LibrarianServiceImpl;

public class Main {

	public static void main(String[] args) {

		LibrarianService service = new LibrarianServiceImpl();
		Library library = new Library();
		try {
			service.fillLibraryFromFile(library);
			service.printCatalog(library);

			Print book = new Book("Таинственный остров.", "Ж.Верн", 2002, 576);
			service.addBook(library, book);
			service.writeLibraryCatalog(library);
		} catch (LibrarianServiceException e) {
			System.out.println(e.getMessage());
		}
	}

}
