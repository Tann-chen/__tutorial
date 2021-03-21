package turotial.models;

import java.util.List;
import java.util.UUID;

public class ClassModel {

    private String classId;
    private TeacherModel teacher;
    private ClassRoomModel classRoom;
    private List<StudentModel> students;

    public ClassModel() {
        this.classId = UUID.randomUUID().toString();
    }

    public String getClassId() {
        return classId;
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
}
