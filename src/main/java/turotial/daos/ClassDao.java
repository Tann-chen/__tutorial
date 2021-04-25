package turotial.daos;

import turotial.models.ClassModel;

public interface ClassDao {

    ClassModel getClassById(String classId);

    boolean isExistClass(String classId);

    void deleteClassById(String classId);

    void updateClassStatus(String status, String classId);
}
