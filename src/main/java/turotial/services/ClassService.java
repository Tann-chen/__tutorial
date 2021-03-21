package turotial.services;

import turotial.dtos.ClassDTO;
import turotial.models.ClassModel;

public interface ClassService {
    ClassModel recordClass(ClassDTO classDTO);

    ClassStatus getClassStatus(String classId);

    void closeClass(String classId);

    boolean isValidClass(String classId);

    enum ClassStatus {
        IN_PROCESS, CLOSED
    }
}
