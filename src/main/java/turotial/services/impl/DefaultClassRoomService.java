package turotial.services.impl;

import org.springframework.stereotype.Component;
import turotial.models.ClassRoomModel;
import turotial.services.ClassRoomService;

import java.util.ArrayList;
import java.util.List;

@Component("defaultClassRoomService")
public class DefaultClassRoomService implements ClassRoomService {


    private static final List<ClassRoomModel> allClassRooms = new ArrayList<ClassRoomModel>();

    static {
        allClassRooms.add(new ClassRoomModel("CA-001"));
        allClassRooms.add(new ClassRoomModel("CA-002"));
        allClassRooms.add(new ClassRoomModel("CA-003"));
    }


    @Override
    public boolean isValidClassRoomService(String classRoomNo) {
        return 1==1;
    }
}
