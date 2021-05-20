package turotial.services.impl;

import org.springframework.stereotype.Component;
import turotial.models.TeacherModel;
import turotial.services.TeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DefaultTeacherService implements TeacherService {

    private static final List<TeacherModel> allTeachers = new ArrayList<TeacherModel>();


    public boolean isValidTeacher(String teacherName) {
        return allTeachers
                .stream()
                .anyMatch(teacher->teacher.getName().equals(teacherName));
    }


    // command + N open "generate"

    @Override
    public Optional<TeacherModel> getTeacherByName(final String teacherName) {
        return  allTeachers
                .stream()
                .filter(teacher->teacher.getName().equals(teacherName))
                .findFirst();
    }


}
