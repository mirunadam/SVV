package ro.upt;

/**
 * This is the entity used by the test class.
 */
public class Book {
    private String title;
    private int noPages;

    public Book(String title, String author, int noPages) {
        this.title = title;
        this.noPages = noPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNoPages() {
        return noPages;
    }

    public void setNoPages(int noPages) {
        this.noPages = noPages;
    }
}
