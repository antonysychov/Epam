package HomeWork.HomeWork16.DBConnectionPool;

import javax.naming.NamingException;
import java.sql.*;

public class Test {
    public static void main(String[] args) throws SQLException, NamingException, ClassNotFoundException {
        DBConnectionPool pool = new DBConnectionPool(5, "jdbc:mysql://localhost:3306/", "root", "");

        Connection c1 = pool.getConnection();
        Statement s1 = c1.createStatement();
        s1.execute("USE dataBase1");
        s1.execute("INSERT INTO TABLE1 VALUES (1, 'Chester', 'Ben')");
        pool.putConnection(c1);
    }
}
