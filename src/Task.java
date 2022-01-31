public class Task {

     public String name;
     public String description;
     public String state;

    public Task(String name, String description, String state) {
        this.name = name;
        this.description = description;
        this.state = state;

    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
