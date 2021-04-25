package turotial.daos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import turotial.daos.ClassDao;
import turotial.daos.ClassRoomDao;
import turotial.models.ClassRoomModel;

import java.util.Optional;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcClassRoomDao implements ClassRoomDao {

    private JdbcTemplate jdbcTemplate;

    private static final String GET_CLASSROOM = "SELECT * FROM classroom WHERE no = ?";
    private static String CHECK_CLASSROOM_EXISTENCE = "SELECT COUNT(id) FROM classroom WHERE id = ?";

    @Override
    public Optional<ClassRoomModel> getClassRoomByNo(String classRoomNo) {
        ClassRoomModel classroom = jdbcTemplate.queryForObject(GET_CLASSROOM, (resultSet, line) -> {
        ClassRoomModel classRoom = new ClassRoomModel();
        classRoom.setClassRoomNo(resultSet.getString("no"));
        return classRoom;
        });
        return Optional.ofNullable(classroom);
    }

    @Override
    public Boolean isExistClassRoom(String classRoomNo) {
        Integer result = jdbcTemplate.queryForObject(CHECK_CLASSROOM_EXISTENCE, Integer.class);
        return result > 0;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
