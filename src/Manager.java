import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    public int id = 0;
    public HashMap<Integer, Task> listOfTask = new HashMap<>();
    public HashMap<Integer, Subtask> listOfSubtask = new HashMap<>();
    public HashMap<Integer, Epic> listOfEpic = new HashMap<>();


    public void createTask(String name, String description) {
        String state = "NEW";
        listOfTask.put(id, new Task(name, description, state));
        id++;
    }

    public void createEpic(String name, String description) {
        String state = "NEW";
        listOfEpic.put(id, new Epic(name, description, state, new ArrayList<Integer>()));
        id++;
    }

    public void createSubtask(String name, String description, int epicId) {
        String state = "NEW";
        listOfSubtask.put(id, new Subtask(name, description, state, epicId));
        Epic var = listOfEpic.get(epicId);
        var.subtaskArrayList.add(id);
        listOfEpic.put(epicId, var);
        id++;
    }

    public Task returnTaskById(int taskId) {
        return listOfTask.get(taskId);
    }

    public Epic returnEpicById(int epicId) {
        return listOfEpic.get(epicId);
    }

    public Subtask returnSubtaskById(int subtaskId) {
        return listOfSubtask.get(subtaskId);
    }

    public void updateTask(Task task, int taskId) {
        listOfTask.put(taskId, task);
    }

    public void updateEpic(Epic epic, int epicId) {
        int counter = 0;
        int countNew = 0;
        int countDone = 0;

        Epic var1 = listOfEpic.get(epicId);
        for (int i : var1.subtaskArrayList) {
            Subtask var = returnSubtaskById(i);
            switch (var.state) {
                case ("NEW"):
                    countNew++;
                    counter++;
                case ("DONE"):
                    countDone++;
                    counter++;
            }
        }

        if (counter == 0) {
            epic.state = "NEW";
        } else if (countNew == counter) {
            epic.state = "NEW";
        } else if (countDone == counter) {
            epic.state = "DONE";
        } else {
            epic.state = "IN PROGRESS";
        }

        listOfEpic.put(epicId, epic);
    }

    public void printSubtasksForEpic(int idEpic) {
        Epic var = returnEpicById(idEpic);
        for (int i : var.subtaskArrayList) {
            System.out.println(returnSubtaskById(i));
        }
    }

    public void updateSubtask(Subtask subtask, int subtaskId) {
        listOfSubtask.put(subtaskId, subtask);
    }

    public void receiveAllTasks(HashMap<Integer, Task> listOfTask) {
        System.out.println(listOfTask.toString());
    }

    public void reciveAllEpics(HashMap<Integer, Epic> listOfEpic) {
        System.out.println(listOfEpic.toString());
    }

    public void reciveAllSubtasks(HashMap<Integer, Subtask> listOfSubtask) {
        System.out.println(listOfSubtask.toString());
    }

    public void deleteAllTasks(HashMap<Integer, Task> listOfTask) {
        listOfTask.clear();
    }

    public void deleteAllEpics(HashMap<Integer, Epic> listOfEpic) {
        listOfEpic.clear();
    }

    public void deleteAllSubtasks(HashMap<Integer, Subtask> listOfSubtask) {
        listOfSubtask.clear();
    }

    public void deleteTaskById(int taskId) {
        listOfTask.remove(taskId);
    }

    public void deleteEpicById(int epicId) {
        listOfEpic.remove(epicId);
    }

    public void deleteSubtaskById(int subtaskId) {
        listOfSubtask.remove(subtaskId);
    }

}
