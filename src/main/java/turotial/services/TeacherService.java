package turotial.services;

import turotial.models.TeacherModel;

import java.util.Optional;

public interface TeacherService {

    boolean isValidTeacher(String teacherName);
    Optional<TeacherModel> getTeacherByName(String teacherName) ;
}
