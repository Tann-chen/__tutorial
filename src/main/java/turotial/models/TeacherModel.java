package turotial.models;

public class TeacherModel {
    private Long id;
    private String name;

    public TeacherModel() {
    }

    public TeacherModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
