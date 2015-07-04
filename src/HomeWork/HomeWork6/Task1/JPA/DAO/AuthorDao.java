package HomeWork.HomeWork6.Task1.JPA.DAO;

import HomeWork.HomeWork6.Task1.Catalogue;
import HomeWork.HomeWork6.Task1.JPA.Models.Author;

public interface AuthorDao {

    int addAuthor();

    Author getAuthor(int libraryCard);

    void updateAuthor();

    void deleteAuthor();

    default void updateCatalogue (){
        Catalogue.update();
    }
}
