package turotial.daos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import turotial.daos.TeacherDao;
import turotial.models.TeacherModel;

import java.util.Optional;

public class JdbcTeacherDao implements TeacherDao {
    private JdbcTemplate jdbcTemplate;
    private static final String GET_TEACHER = "SELECT * FROM teacher WHERE no = ?";
    private static String CHECK_TEACHER_EXISTENCE = "SELECT COUNT(id) FROM teacher WHERE id = ?";

    @Override
    public Optional<TeacherModel> getTeacherByName(String teacherName) {
        TeacherModel teacher = jdbcTemplate.queryForObject(GET_TEACHER, (resultSet, line) -> {
        TeacherModel teacherModel = new TeacherModel();
        teacherModel.setName(resultSet.getString("name"));
        teacherModel.setId(resultSet.getLong("id"));
        return teacherModel;});
        return Optional.ofNullable(teacher);
    }

    @Override
    public Boolean isExistTeacher(String studentName) {
        Integer result = jdbcTemplate.queryForObject(CHECK_TEACHER_EXISTENCE, Integer.class);
        return result > 0;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
