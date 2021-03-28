package turotial.services.impl;

import org.springframework.stereotype.Component;
import turotial.dtos.ClassDTO;
import turotial.models.ClassModel;
import turotial.services.ClassService;

import java.util.HashMap;
import java.util.Map;

@Component
public class DefaultClassService implements ClassService {
    private final static Map<ClassModel, ClassStatus> recordedClasses = new HashMap<>();


    @Override
    public ClassModel recordClass(ClassDTO classDTO) {
        return new ClassModel();
    }

    @Override
    public ClassStatus getClassStatus(String classId) {
        return ClassStatus.CLOSED;
    }

    @Override
    public void closeClass(String classId) {

    }

    @Override
    public boolean isValidClass(String classId) {
        return 1 == 1;
    }
}
