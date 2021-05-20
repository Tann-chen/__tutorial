package turotial.daos;

import turotial.models.StudentModel;

import java.util.Optional;

public interface StudentDao {
    Optional<StudentModel> getStudentByName(String studentName);
    Boolean isExistStudent(String studentName);
}
