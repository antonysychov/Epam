package HomeWork.HomeWork6.Task1;

import HomeWork.HomeWork6.Task1.JPA.Models.Book;
import HomeWork.HomeWork6.Task1.JPA.Models.User;

import java.sql.Date;
import java.util.List;

/**
 * Class, representing electronic library
 */
public class Library {

    private Catalogue catalogue;
    private List<User> users;
    private List<Order> orders;

    /**
     * @param user
     * @return new user library card number
     */
    public int registerUser(User user) {
        return 0;
    }

    /**
     * edits user's data
     *
     * @param libraryCard
     */
    private void editUser(int libraryCard) {
    }

    /**
     * deletes user from database
     *
     * @param libraryCard
     */
    public void deleteUser(int libraryCard) {
    }

    /**
     * @param libraryCode
     * @return book in request
     */
    public Book giveBook(int libraryCode) {
        return null;
    }

    /**
     * accepts book from user
     *
     * @param libraryCode
     */
    public void acceptBook(int libraryCode) {
    }

    /**
     * @return catalogue instance
     */

    /**
     * @param from - start time point
     * @param to   - end time point
     * @return books that were if occupied within the period
     */
    private List<Book> givenBooksWithinPeriod(Date from, Date to) {
        return null;
    }

    /**
     * @param from - start time point
     * @param to   - end time point
     * @returnreturned books within the period
     */
    private List<Book> returnedBooksWithinPeriod(Date from, Date to) {
        return null;
    }

    /**
     * @param userLibraryCard
     * @return books taken by user
     */
    private List<Book> booksOccupiedByUser(int userLibraryCard) {
        return null;
    }

    /**
     * check if the book available
     *
     * @param book
     * @return the book availability
     */
    private boolean checkBookAvailability(Book book) {
        return false;
    }
}
