package jdbc_test.jdbc_test_1;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static Properties properties = new Properties();

    static {
        InputStream is = DBConnection.class.getResourceAsStream("/db.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 这个mysqlConnection只是为了用来从里面读一个PreparedStatement，不会往里面写数据，因此没有线程安全问题，可以作为一个全局变量
     */
    public static Connection mysqlConnection = getConnection();

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(properties.getProperty("mysqlPackage"));
            con = DriverManager.getConnection(properties.getProperty("mysqlUrl"),
                    properties.getProperty("mysqlUsername"),
                    properties.getProperty("mysqlPassword"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
