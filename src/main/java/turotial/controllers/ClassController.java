package turotial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import turotial.exceptions.NoFoundException;
import turotial.dtos.ClassDTO;
import turotial.models.ClassModel;
import turotial.services.ClassRoomService;
import turotial.services.ClassService;
import turotial.services.StudentService;
import turotial.services.TeacherService;

import javax.validation.Valid;
import java.util.Optional;


//@Controller + @ResponseBody

@RestController
@RequestMapping("/class")  // HandlerMapping
public class ClassController {

    private ClassRoomService classRoomService;

    private StudentService studentService;

    private TeacherService teacherService;

    private ClassService classService;

    /*
     * Request
     *
     * Header - url
     * 1. path variable: /class/{name}
     * 2. request parameter /class?name=
     * Body -> @RequestBody
     */
    // /class/{name}  // path variable
    // /class?name=XXX  //request parameter


    @RequestMapping(method = RequestMethod.POST)   // HandlerAdaptor
    public ResponseEntity<String> createClass(@RequestBody @Valid final ClassDTO classData, final BindingResult bindingResult) {
        if (bindingResult.hasErrors() || !checkClassDataValidation(classData)) {
            return ResponseEntity.badRequest().build(); //400 at response header
        }

        final ClassModel classRecord = classService.addClass(classData);

        return ResponseEntity.ok().body(classRecord.getClassId().toString());
    }

    // RESTFUL API
    @RequestMapping(value = "/{classId}", method = RequestMethod.GET)
    public ResponseEntity<ClassModel> getClassStatus(@PathVariable(name = "classId") final String classId) {
        final Optional<ClassModel> classModel = classService.getClassById(classId);
        return ResponseEntity.of(classModel);
    }

    @RequestMapping(value = "/{classId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteClass(@PathVariable(name = "classId") final String classId) {
        boolean noFound = false;
        try {
            classService.deleteClassById(classId);
        } catch (NoFoundException ex) {
            noFound = true;
        }

        return noFound ? ResponseEntity.notFound().build() : ResponseEntity.ok().build();
    }



    private boolean checkClassDataValidation(final ClassDTO classDTO) {
        if (!classRoomService.isValidClassRoomService(classDTO.getClassRoomNo())) {
            return false;
        }
        if (!teacherService.isValidTeacher(classDTO.getTeachName())) {
            return false;
        }
        for (String studentName : classDTO.getStudentNames()) {
            if (!studentService.isValidStudent(studentName)) {
                return false;
            }
        }
        return true;
    }


    @Autowired
    public void setClassRoomService(@Qualifier("defaultClassRoomService") ClassRoomService classRoomService) {
        this.classRoomService = classRoomService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Autowired
    public void setClassService(ClassService classService) {
        this.classService = classService;
    }
}
