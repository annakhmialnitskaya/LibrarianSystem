package by.htp.library.dao;

import java.util.List;

import by.htp.library.bean.Print;
import by.htp.library.util.PrintConvertException;

public interface LibraryDao {

	List<Print> readInfoBooks() throws LibrarianDaoException, PrintConvertException;

	List<Print> readInfoNewspapers() throws LibrarianDaoException, PrintConvertException;

	List<Print> readInfoMagazins() throws LibrarianDaoException, PrintConvertException;

	void writeInfoBooks(List<Print> list) throws LibrarianDaoException;

	void writeInfoNewspapers(List<Print> list) throws LibrarianDaoException;

	void writeInfoMagazins(List<Print> list) throws LibrarianDaoException;
}
