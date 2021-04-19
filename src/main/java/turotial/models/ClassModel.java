package turotial.models;

import org.springframework.stereotype.Component;
import turotial.services.ClassService;

import java.util.List;
import java.util.UUID;

@Component
public class ClassModel {

    private String classId;
    private TeacherModel teacher;
    private ClassRoomModel classRoom;
    private List<StudentModel> students;
    private ClassService.ClassStatus status;

    public ClassModel() {
        this.classId = UUID.randomUUID().toString();
        this.status = ClassService.ClassStatus.READY;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public TeacherModel getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherModel teacher) {
        this.teacher = teacher;
    }

    public ClassRoomModel getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoomModel classRoom) {
        this.classRoom = classRoom;
    }

    public List<StudentModel> getStudents() {
        return students;
    }

    public void setStudents(List<StudentModel> students) {
        this.students = students;
    }

    public ClassService.ClassStatus getStatus() {
        return status;
    }

    public void setStatus(ClassService.ClassStatus status) {
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = ClassService.ClassStatus.valueOf(status);
    }

}
