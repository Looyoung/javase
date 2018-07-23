package jdbc_test;

import java.util.List;

public class JdbcTest {
    public static void main(String[] args) throws Exception {
        List<Student> studentList = StudentManager.getInstance().querySomeStudents("Louis");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
