package by.htp.library.bean;

import java.util.ArrayList;
import java.util.List;

public class Library {

	List<Print> books = new ArrayList<>();
	List<Print> newspapers = new ArrayList<>();
	List<Print> magazins = new ArrayList<>();

	public List<Print> getBooks() {
		return books;
	}

	public void setBooks(List<Print> list) {
		this.books = list;
	}

	public List<Print> getNewspapers() {
		return newspapers;
	}

	public void setNewspapers(List<Print> newspapers) {
		this.newspapers = newspapers;
	}

	public List<Print> getMagazins() {
		return magazins;
	}

	public void setMagazins(List<Print> magazins) {
		this.magazins = magazins;
	}

}
