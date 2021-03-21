package turotial.services.impl;

import org.springframework.stereotype.Component;
import turotial.models.ClassModel;
import turotial.services.ClassService;

import java.util.HashMap;
import java.util.Map;

@Component
public class DefaultClassService implements ClassService {
    private final static Map<ClassModel, ClassStatus> recordedClasses = new HashMap<>();


}
