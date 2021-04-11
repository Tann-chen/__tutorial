package turotial;

public class NoFoundException extends Exception {
    public NoFoundException(String classId){
        super("classID not exist" + classId);
    }
}
