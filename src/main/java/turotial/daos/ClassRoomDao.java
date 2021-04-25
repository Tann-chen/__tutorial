package turotial.daos;

import turotial.models.ClassRoomModel;

import java.util.Optional;

public interface ClassRoomDao {
    Optional<ClassRoomModel> getClassRoomByNo(String classRoomNo);
    Boolean isExistClassRoom(String classRoomNo);
}
