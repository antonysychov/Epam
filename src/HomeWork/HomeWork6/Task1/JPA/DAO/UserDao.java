package HomeWork.HomeWork6.Task1.JPA.DAO;

import HomeWork.HomeWork6.Task1.Catalogue;
import HomeWork.HomeWork6.Task1.JPA.Models.User;

public interface UserDao {
    int addUser ();
    User getUser(int libraryCard);
    void updateUser ();
    void deleteUser ();

    default void updateCatalogue (){
        Catalogue.update();
    }
}
