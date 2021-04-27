package turotial.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import turotial.exceptions.NoFoundException;
import turotial.dtos.ClassDTO;
import turotial.models.*;
import turotial.services.ClassRoomService;
import turotial.services.ClassService;
import turotial.services.StudentService;
import turotial.services.TeacherService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DefaultClassService implements ClassService {

    private final static Map<String, ClassModel> recordedClasses = new ConcurrentHashMap<>();

    private ClassRoomService classroomService;
    private StudentService studentService;
    private TeacherService teacherService;


    @Override
    public ClassModel addClass(final ClassDTO classDTO) {
        final ClassModel newClass = new ClassModel();

        final ClassRoomModel classRoomModel = classroomService.getClassRoomByNo(classDTO.getClassRoomNo()).orElseThrow(RuntimeException::new);
        newClass.setClassRoom(classRoomModel);

        final TeacherModel teacherModel = teacherService.getTeacherByName(classDTO.getTeacherName()).orElseThrow(RuntimeException::new);
        newClass.setTeacher(teacherModel);

        final List<String> studentList = classDTO.getStudentNames();
        for (String studentName : studentList) {
            StudentModel student = studentService.getStudentByName(studentName).orElseThrow(RuntimeException::new);
            newClass.getStudents().add(student);
        }

        recordedClasses.put(newClass.getClassId().toString(), newClass);
        return newClass;
    }



    @Override
    public Optional<ClassModel> getClassById(String classId) {
        return Optional.ofNullable(recordedClasses.get(classId));
    }

    @Override
    public void closeClass(String classId) throws NoFoundException {
        ClassModel targetClass = recordedClasses.get(classId);
        if (targetClass == null) {
            throw new NoFoundException(classId);
        }

        targetClass.setStatus(ClassStatus.CLOSED);
    }

    @Override
    public boolean isValidClass(String classId) {
        return recordedClasses.containsKey(classId);
    }

    @Override
    public void deleteClassById(final String classId) throws NoFoundException {
        ClassModel removed = recordedClasses.remove(classId);
        if (removed == null) {
            throw new NoFoundException(classId);
        }
    }

    @Autowired
    public void setClassroomService(@Qualifier("defaultClassRoomService") ClassRoomService classroomService) {
        this.classroomService = classroomService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
}

