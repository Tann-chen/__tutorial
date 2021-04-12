package turotial.services.impl;

import org.springframework.stereotype.Component;
import turotial.models.ClassRoomModel;
import turotial.services.ClassRoomService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("defaultClassRoomService")
public class DefaultClassRoomService implements ClassRoomService {


    private static final List<ClassRoomModel> allClassRooms = new ArrayList<ClassRoomModel>();

    static {
        allClassRooms.add(new ClassRoomModel("CA-001"));
        allClassRooms.add(new ClassRoomModel("CA-002"));
        allClassRooms.add(new ClassRoomModel("CA-003"));
    }


    @Override
    public boolean isValidClassRoomService(final String classRoomNo) {
        return allClassRooms
                .stream()
                .anyMatch(classroom->classroom.getClassRoomNo().equals(classRoomNo));
    }

    @Override
    public Optional<ClassRoomModel> getClassRoomByNo(final String classRoomNo) {
        return allClassRooms
                .stream()
                .filter(classroom->classroom.getClassRoomNo().equals(classRoomNo))
                .findFirst();
    }


}
