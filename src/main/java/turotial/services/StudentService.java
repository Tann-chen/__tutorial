package turotial.services;

import turotial.models.StudentModel;

import java.util.Optional;

public interface StudentService {

    Optional<StudentModel> getStudentByName(String studentName) ;

    boolean isValidStudent(String studentName);


}
