package HomeWork.HomeWork16.DBConnectionPool;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;


public class DBConnectionPool {
    private BlockingQueue<Connection> connections;

    public DBConnectionPool(int connectionsCount, String url, String username, String password)
            throws SQLException, ClassNotFoundException, NamingException {

        connections = new ArrayBlockingQueue<Connection>(connectionsCount);

        Class.forName(DataBasesDriver.MYSQL.toString());
        for (int i = 0; i < connectionsCount; i++) {
            connections.add(DriverManager.getConnection(url, username, password));
        }
    }

    public Connection getConnection() throws SQLException {
        try {
            return connections.poll(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            return null;
        }
    }

    public void putConnection(Connection connection) throws SQLException {
        connections.add(connection);
    }

    public enum DataBasesDriver {
        MYSQL("com.mysql.jdbc.Driver"), POSTGRES("");

        private String url;

        DataBasesDriver(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return url;
        }
    }
}
