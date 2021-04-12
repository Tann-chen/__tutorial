package turotial.services.impl;

import org.springframework.stereotype.Component;
import turotial.NoFoundException;
import turotial.dtos.ClassDTO;
import turotial.models.*;
import turotial.services.ClassService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DefaultClassService implements ClassService {

    private final static Map<String, ClassModel> recordedClasses = new HashMap<>();

    private final DefaultClassRoomService classroomService;
    private final DefaultStudentService studentService;
    private final DefaultTeacherService teacherService;

    public DefaultClassService(DefaultClassRoomService classroomService,
                               DefaultStudentService studentService,
                               DefaultTeacherService teacherService) {
        this.classroomService = classroomService;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

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

        recordedClasses.put(newClass.getClassId(), newClass);
        return newClass;
    }



    @Override

    public ClassModel getClassById(String classId) {
        return recordedClasses.get(classId);
    }

    @Override
    public void closeClass(String classId) throws NoFoundException{
        ClassModel TargetClass = recordedClasses.get(classId);
        if (TargetClass == null) {
            throw new NoFoundException(classId);
        } else {
            TargetClass.setStatus(ClassStatus.CLOSED); // Do I need to update map ?
            recordedClasses.put(classId,TargetClass);
        }

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
}

