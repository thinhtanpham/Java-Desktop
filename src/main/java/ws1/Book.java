package ws1;

import java.util.Objects;

public class Book {

    private String id;
    private String title;
    private String author;
    private boolean status;
    private String keyword;
    private String category;

    public Book() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Book)) {
            return false;
        }
        Book book = (Book) o;
        return isStatus() == book.isStatus() && Objects.equals(getId(), book.getId())
                && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getAuthor(), book.getAuthor())
                && Objects.equals(getKeyword(), book.getKeyword()) && Objects.equals(getCategory(), book.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getAuthor(), isStatus(), getKeyword(), getCategory());
    }

    public Book(String id, String title, String author, boolean status, String keyword, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.status = status;
        this.keyword = keyword;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" + "id='" + id + '\'' + ", title='" + title + '\'' + ", author='" + author + '\'' + ", status="
                + status + ", keyword='" + keyword + '\'' + ", category='" + category + '\'' + '}';
    }
}
