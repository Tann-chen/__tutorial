package turotial.services.impl;

import org.springframework.stereotype.Component;
import turotial.models.StudentModel;
import turotial.services.StudentService;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultStudentService implements StudentService {

    private static final List<StudentModel> allStudents = new ArrayList<StudentModel>();

    static {
        allStudents.add(new StudentModel("zhangsan"));
        allStudents.add(new StudentModel("lisi"));
        allStudents.add(new StudentModel("wangwu"));
        allStudents.add(new StudentModel("zhaoliu"));
        allStudents.add(new StudentModel("chenqi"));
    }
}
