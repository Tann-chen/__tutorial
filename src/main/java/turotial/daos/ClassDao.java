package turotial.daos;

import org.springframework.data.repository.CrudRepository;
import turotial.models.ClassModel;
import turotial.services.ClassService;

import java.util.List;

public interface ClassDao extends CrudRepository<ClassModel, Integer> {

    List<ClassModel> findByStatusEquals(ClassService.ClassStatus status);
}
