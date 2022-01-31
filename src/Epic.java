import java.util.ArrayList;

public class Epic extends Task {
    public ArrayList<Integer> subtaskArrayList;

    public Epic(String name, String description, String state, ArrayList<Integer> subtaskArrayList) {
        super(name, description, state);
        this.subtaskArrayList = subtaskArrayList;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "subtaskArrayList=" + subtaskArrayList +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
