package libraryCatalogue;

public class libBook {
    private String isbn;
    private String title;

    public libBook(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + ", Title: " + title;
    }
}