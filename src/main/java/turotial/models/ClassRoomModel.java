package turotial.models;

import javax.persistence.*;

@Entity
@Table(name = "classroom")
public class ClassRoomModel {
    @Id
    @Column(name = "no")
    private Integer classRoomNo;

    public Integer getClassRoomNo() {
        return classRoomNo;
    }

    public void setClassRoomNo(Integer classRoomNo) {
        this.classRoomNo = classRoomNo;
    }
}
