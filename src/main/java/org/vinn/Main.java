package org.vinn;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        dataSource.setUrl("jdbc:mysql://localhost:3306/jdbc_template_database?useSSL=false&serverTimezone=UTC");

        dataSource.setUsername("root");
        dataSource.setPassword("mysql");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        StudentDao studentDao = new StudentDao(jdbcTemplate);

        System.out.println("Adding new students to MySQL...");
        studentDao.addStudent("Eve", "eve@mysql.com");
        studentDao.addStudent("Frank", "frank@mysql.com");

        System.out.println("\nFinding all students from MySQL:");
        List<Student> students = studentDao.findAllStudents();
        students.forEach(System.out::println);
    }
}