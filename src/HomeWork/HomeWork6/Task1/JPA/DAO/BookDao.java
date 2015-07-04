package HomeWork.HomeWork6.Task1.JPA.DAO;

import HomeWork.HomeWork6.Task1.Catalogue;
import HomeWork.HomeWork6.Task1.JPA.Models.Book;

public interface BookDao {
    int addBook();

    Book getBook(int libraryCode);

    void updateBook();

    void deleteBook();

    default void updateCatalogue (){
        Catalogue.update();
    }

}
