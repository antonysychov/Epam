package HomeWork.HomeWork6.Task1;

import HomeWork.HomeWork6.Task1.JPA.Models.Book;
import HomeWork.HomeWork6.Task1.JPA.Models.User;

import java.util.List;

public class Order {
    private User user;
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
