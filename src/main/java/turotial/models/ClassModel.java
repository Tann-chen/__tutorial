package turotial.models;

import turotial.services.ClassService;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "class")
public class ClassModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer classId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private TeacherModel teacher;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "classroom_no", referencedColumnName = "no")
    private ClassRoomModel classRoom;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "class2student",
            joinColumns = @JoinColumn(name = "class_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id")
    )
    private List<StudentModel> students;

    @Column(name = "status", nullable = false, columnDefinition = "varchar(10) default 'READY'")
    @Enumerated(value = EnumType.STRING)
    private ClassService.ClassStatus status;


    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
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
}
