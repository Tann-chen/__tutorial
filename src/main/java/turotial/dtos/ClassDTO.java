package turotial.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ClassDTO {
    @NotNull
    private String teachName;

    @NotEmpty
    private List<String> studentNames;

    @NotNull
    private String classRoomNo;


    public String getTeachName() {
        return teachName;
    }

    public void setTeachName(String teachName) {
        this.teachName = teachName;
    }

    public List<String> getStudentNames() {
        return studentNames;
    }

    public void setStudentNames(List<String> studentNames) {
        this.studentNames = studentNames;
    }

    public String getClassRoomNo() {
        return classRoomNo;
    }

    public void setClassRoomNo(String classRoomNo) {
        this.classRoomNo = classRoomNo;
    }

    public String getTeacherName() { return teachName;}
    }
