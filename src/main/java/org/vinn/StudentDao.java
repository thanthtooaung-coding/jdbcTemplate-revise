package org.vinn;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDao {

    private final JdbcTemplate jdbcTemplate;
    private static final StudentRowMapper STUDENT_ROW_MAPPER = new StudentRowMapper();

    public StudentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addStudent(String name, String email) {
        String sql = "INSERT INTO students (name, email) VALUES (?, ?)";
        jdbcTemplate.update(sql, name, email);
    }

    public Student findStudentById(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, STUDENT_ROW_MAPPER, id);
    }

    public List<Student> findAllStudents() {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, STUDENT_ROW_MAPPER);
    }
}