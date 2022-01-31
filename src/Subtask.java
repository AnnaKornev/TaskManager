public class Subtask  extends Task {
    int idEpic;

    public Subtask(String name, String description, String state, int idEpic) {
        super(name, description, state);
        this.idEpic = idEpic;
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "idEpic=" + idEpic +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
