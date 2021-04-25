package turotial.daos;

import turotial.models.StudentModel;
import turotial.models.TeacherModel;

import java.util.Optional;

public interface TeacherDao {
    Optional<TeacherModel> getTeacherByName(String teacherName);
    Boolean isExistTeacher(String studentName);
}
