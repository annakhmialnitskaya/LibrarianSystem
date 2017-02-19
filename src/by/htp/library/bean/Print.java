package by.htp.library.bean;

public abstract class Print {

	private String title;
	private int numberOfPages;

	public Print(String title, int numberOfPages) {
		this.title = title;
		this.numberOfPages = numberOfPages;
	}

	public String getTitle() {
		return title;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numberOfPages;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Print other = (Print) obj;
		if (numberOfPages != other.numberOfPages)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
