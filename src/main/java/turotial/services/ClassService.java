package turotial.services;

import turotial.NoFoundException;
import turotial.dtos.ClassDTO;
import turotial.models.ClassModel;

public interface ClassService {
    ClassModel addClass(ClassDTO classDTO);

    ClassModel getClassById(String classId);

    void closeClass(String classId) throws NoFoundException;

    boolean isValidClass(String classId);

    void deleteClassById(String classId) throws NoFoundException;

    enum ClassStatus {
        READY,IN_PROCESS, CLOSED
    }
}
