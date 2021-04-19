package turotial.exceptions;

public class NoFoundException extends Exception {
    public NoFoundException(String classId){
        super("classID not exist" + classId);
    }
}
