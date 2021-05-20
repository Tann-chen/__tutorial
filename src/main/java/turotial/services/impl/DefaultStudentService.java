package turotial.services.impl;

import org.springframework.stereotype.Component;
import turotial.models.StudentModel;
import turotial.services.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DefaultStudentService implements StudentService {

    private static final List<StudentModel> allStudents = new ArrayList<StudentModel>();


    @Override
    public Optional<StudentModel> getStudentByName(String studentName) {
        return allStudents
                .stream()
                .filter(student->student.getName().equals(studentName))
                .findFirst();
    }

    @Override
    public boolean isValidStudent(String studentName) {
        return allStudents
                .stream()
                .anyMatch(student->student.getName().equals(studentName));
    }
}
