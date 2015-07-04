package Lessons.Lesson24.JDBC;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbcc.Driver");
        String url = "jdbc::mysql://127.0.0.1:3306/mytestdb10";

        Connection con = DriverManager.getConnection(url, "root", "root");
        ///con.setAutoCommit(false);

        PreparedStatement ps = con.prepareStatement("SELECT * FROM mytable WHERE name = ?");
        ps.setString(1, "ccc");                 //вместо первого знака вопроса подставить "ccc"
        ResultSet rs1 = ps.executeQuery();
        //con.commit();

        String sql = "{call myprocedure(?, ?)}";
        CallableStatement cs = con.prepareCall(sql);
        cs.setInt(1, 1);
        cs.registerOutParameter(2, java.sql.Types.VARCHAR);
        cs.execute();

        String res= cs.getString(2);
        System.out.println(res);

        Statement st = con.createStatement();
        boolean b = st.execute("INSERT INTO mytable VALUES(1,2,4)");


        ResultSet rs = st.executeQuery("SELECT * FROM mytable");
        ResultSetMetaData rsmd = rs.getMetaData();
        int columns = rsmd.getColumnCount();
        while (rs.next()) {              //пытаеться передвинуть итератор, и возвращаем успех операции
            for (int i = 0; i <= columns; i++) {            //нумерация столбцов начинаеться с единицы
                System.out.format(rs.getString(i) + " ");
            }
            System.out.println();
        }
        con.close();
    }
}
