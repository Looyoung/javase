package jdbc_test.jdbc_test_1;

import org.junit.Test;
import sun.plugin2.main.server.ResultHandler;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JdbcTest {

    @Test
    public void jdbcTest1() throws Exception {
        List<Student> studentList = StudentManager.getInstance().querySomeStudents("Louis");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void jdbcTest2() throws Exception {
        Properties properties = new Properties();
        InputStream inputStream = Object.class.getResourceAsStream("/db.properties");
        properties.load(inputStream);
        //System.out.println(properties.getProperty("mysqlPackage"));
        Class.forName(properties.getProperty("mysqlPackage"));
        Connection connection = DriverManager.getConnection(properties.getProperty("mysqlUrl"),
                properties.getProperty("mysqlUsername"), properties.getProperty("mysqlPassword"));
        Statement statement = connection.createStatement();
        String sqlUpdate = "update student set studentAge = 25 where studentName = 'Louis'";
        int i = statement.executeUpdate(sqlUpdate);
        System.out.println("执行更新成功，对 " + i + " 条数据产生影响！");
        String sqlQuery = "select * from student where studentName = 'Louis'";
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        while (resultSet.next()) {
            int id = resultSet.getInt("studentId");
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            String phone = resultSet.getString("studentPhone");
            Student student = new Student(id, name, age, phone);
            System.out.println(student);
        }
    }

    @Test
    public void jdbcTest3() {
        Properties properties = new Properties();
        InputStream inputStream = Object.class.getResourceAsStream("/db.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(properties.getProperty("mysqlPackage"));
        try {
            Class.forName(properties.getProperty("mysqlPackage"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(properties.getProperty("mysqlUrl"),
                    properties.getProperty("mysqlUsername"), properties.getProperty("mysqlPassword"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sqlUpdate = "update student set studentName = ? where studentID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, "Jason");
            preparedStatement.setInt(2, 4);
            boolean b = preparedStatement.execute();
            //true if the first result is a ResultSet object;
            // false if the first result is an update count or there is no result
            System.out.println(b);  // false
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jdbcTest4() {
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = JDBCUtil.getConnection();
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            String sqlQuery = "select * from student where studentId > ?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 2);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
//            System.out.println(databaseMetaData.getURL());
            for (Student student : readResult(resultSet)) {
                System.out.println(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    public List<Student> readResult(ResultSet resultSet) {
        List<Student> students = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("studentId");
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                String phone = resultSet.getString("studentPhone");
                Student student = new Student(id, name, age, phone);
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    /**
     * 插入 BLOB 类型的数据必须使用 PreparedStatement：因为 BLOB 类型
     * 的数据时无法使用字符串拼写的。
     * <p>
     * 调用 setBlob(int index, InputStream inputStream)
     */
    @Test
    public void testInsertBlob() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtil.getConnection();
            String insertSql = "insert into portrait(name,picture) values(?,?)";
            preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, "Louis");
            InputStream inputStream =
                    new FileInputStream("D:\\Louis\\Pictures\\Saved Pictures\\screen-background.jpg");
            preparedStatement.setBlob(2, inputStream);
            preparedStatement.executeUpdate();
            System.out.println(inputStream.available());
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(preparedStatement, connection);
        }
    }

    /**
     * 读取 blob 数据:
     * 1. 使用 getBlob 方法读取到 Blob 对象
     * 2. 调用 Blob 的 getBinaryStream() 方法得到输入流。再使用 IO 操作即可.
     */
    @Test
    public void testReadBlob() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            String querySql = "select * from portrait where id = ?";
            preparedStatement = connection.prepareStatement(querySql);
            preparedStatement.setInt(1, 2);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                Blob picture = resultSet.getBlob(3);
                InputStream inputStream = picture.getBinaryStream();
                System.out.println(inputStream.available());
                OutputStream outputStream = new FileOutputStream("screen-background.jpg");
                byte[] bytes = new byte[1024];
                int len;
                while ((len = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, len);
                }
                inputStream.close();
                outputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(resultSet, preparedStatement, connection);
        }
    }
}
