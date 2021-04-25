package turotial.services;

import org.springframework.lang.Nullable;
import turotial.exceptions.NoFoundException;
import turotial.dtos.ClassDTO;
import turotial.models.ClassModel;

import java.util.Optional;

public interface ClassService {
    ClassModel addClass(ClassDTO classDTO);

//    @Nullable // mark the result is nullable
    Optional<ClassModel> getClassById(String classId);

    void closeClass(String classId) throws NoFoundException;

    boolean isValidClass(String classId);

    void deleteClassById(String classId) throws NoFoundException;

    enum ClassStatus {
        READY,IN_PROCESS, CLOSED
    }
}
