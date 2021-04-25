package turotial.daos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import turotial.daos.ClassDao;
import turotial.models.ClassModel;
import turotial.models.ClassRoomModel;
import turotial.models.StudentModel;
import turotial.models.TeacherModel;

import java.util.List;

public class JdbcClassDao implements ClassDao {
    private static final String GET_CLASS = "SELECT c.id as 'cid', c.status, t.id as 'tid', t.name, cl.no " +
            "   FROM class as c " +
            "       LEFT JOIN teacher as t ON c.teacher_id = t.id " +
            "       LEFT JOIN classroom as cl ON c.classroom_no = cl.no " +
            "   WHERE c.id = ?";

    private static String GET_CLASS_STUDENTS = "SELECT id, name, score" +
            "   FROM student as s " +
            "       LEFT JOIN class2student as rel ON s.id = rel.student_id " +
            "   WHERE rel.class_id = ?";

    private static String CHECK_CLASS_EXISTENCE = "SELECT COUNT(id) FROM class WHERE id = ?";

    private static String DELETE_CLASS = "DELETE FROM class WHERE id = ?";
    private static String UPDATE_CLASS_STATUS = "UPDATE class SET status = ? WHERE id = ?";

    private JdbcTemplate jdbcTemplate;

    @Override
    public ClassModel getClassById(String classId) {
        ClassModel clazz = jdbcTemplate.queryForObject(GET_CLASS, (resultSet, line) -> {
            ClassModel classModel = new ClassModel();
            classModel.setStatus(resultSet.getString("status"));
            classModel.setClassId(resultSet.getString("cid"));

            TeacherModel teacherModel = new TeacherModel();
            teacherModel.setName(resultSet.getString("name"));
            teacherModel.setId(resultSet.getLong("tid"));
            classModel.setTeacher(teacherModel);

            ClassRoomModel classRoomModel = new ClassRoomModel();
            classRoomModel.setClassRoomNo(resultSet.getString("no"));
            classModel.setClassRoom(classRoomModel);
            return classModel;
        });

        if (clazz != null) {
            List<StudentModel> studentOfClass = jdbcTemplate.query(GET_CLASS_STUDENTS, (result, line) -> {
                StudentModel student = new StudentModel();
                student.setName(result.getString("name"));
                student.setScore(result.getInt("score"));
                student.setId(result.getString("id"));
                return student;
            });

            clazz.setStudents(studentOfClass);
        }

        return clazz;
    }

    @Override
    public boolean isExistClass(String classId) {
        Integer result = jdbcTemplate.queryForObject(CHECK_CLASS_EXISTENCE, Integer.class);
        return result > 0;
    }

    @Override
    public void deleteClassById(String classId) {
        jdbcTemplate.queryForObject(DELETE_CLASS, Integer.class);
        //DELETE returns the number of rows that were actually deleted.
    }

    @Override
    public void updateClassStatus(String status, String classId) {
        jdbcTemplate.queryForObject(UPDATE_CLASS_STATUS, Integer.class);
        //UPDATE returns the number of rows that were actually changed.
    }

    //    public static void execute(String name, String className) {
    //        String sql = "INSERT students(name, class) values (?, ?)";
    //        JdbcTemplate jdbcTemplate = jdbcTemplate();
    //        jdbcTemplate.update(sql, name, className);
    //    }
    //
    //    public static List<StudentModel> get() {
    //        String sql = "SELECT name, class from students";
    //        JdbcTemplate jdbcTemplate = jdbcTemplate();
    //
    //        return jdbcTemplate.query(sql, (resultSet, line) -> {
    //            StudentModel studentModel = new StudentModel();
    //            studentModel.setName(resultSet.getString("name"));
    //            studentModel.setClassName(resultSet.getString("class"));
    //            return studentModel;
    //        });
    //    }


    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
