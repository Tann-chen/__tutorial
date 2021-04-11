package turotial.services;

import turotial.models.ClassRoomModel;

import java.util.Optional;

/**
 * why service should has interface:
 * 1. service ofter be override
 * 2.
 */
public interface ClassRoomService {

    boolean isValidClassRoomService(String classRoomNo);

    Optional<ClassRoomModel> getClassRoomByNo(String classRoomNo);
}
