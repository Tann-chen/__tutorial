package turotial.daos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import turotial.daos.StudentDao;
import turotial.models.StudentModel;

import java.util.Optional;

public class JdbcStudentDao implements StudentDao {
    private JdbcTemplate jdbcTemplate;
    private static final String GET_STUDENT = "SELECT * FROM student WHERE no = ?";
    private static String CHECK_STUDENT_EXISTENCE = "SELECT COUNT(id) FROM student WHERE id = ?";
    @Override
    public Optional<StudentModel> getStudentByName(String studentName) {
        StudentModel student = jdbcTemplate.queryForObject(GET_STUDENT, (resultSet, line) -> {
            StudentModel studentModel = new StudentModel();
            studentModel.setName(resultSet.getString("name"));
            studentModel.setScore(resultSet.getInt("score"));
            studentModel.setId(resultSet.getString("id"));
            return studentModel;
        });
        return Optional.ofNullable(student);
    }

    @Override
    public Boolean isExistStudent(String studentName) {
        Integer result = jdbcTemplate.queryForObject(CHECK_STUDENT_EXISTENCE, Integer.class);
        return result > 0;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
