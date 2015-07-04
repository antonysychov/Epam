package HomeWork.HomeWork6.Task1;

import HomeWork.HomeWork6.Task1.JPA.Models.Book;

import java.util.Map;

/**
 * class representing catalogue of books
 * Singleton
 */
public class Catalogue {
    Map<Integer, Book> books;

    /**
     * private constructor makes class singleton
     */
    private Catalogue() {
    }

    /**
     * Catalogue must be unique for all users
     * @return instance of catalogue
     */

    /**
     * listener method that update Catalogue content after
     * database manipulations
     */
    public static void update() {}
}
