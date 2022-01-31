import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.createTask("Task1","example");
        manager.createTask("Task2", "another example");

        manager.createEpic("Epic1", "example");
        manager.createSubtask("Subtask", "Subtask for Epic1", 2);

        manager.createEpic("Epic2", "example");
        manager.createSubtask("Subtask1", "Subtask for Epic2", 4);
        manager.createSubtask("Subtask1", "Another Subtask for Epic2", 4);

        System.out.println(manager.listOfTask);
        System.out.println(manager.listOfSubtask);
        System.out.println(manager.listOfEpic);

        Task task1 = new Task("Task", "newTask", "IN PROGRESS");
        manager.updateTask(task1, 0);
        manager.receiveAllTasks(manager.listOfTask);
        manager.deleteAllTasks(manager.listOfTask);
        manager.reciveAllEpics(manager.listOfEpic);
        
        manager.deleteTaskById(1);
        manager.receiveAllTasks(manager.listOfTask);

        Subtask subtask1 = new Subtask("Subtask", "example", "DONE", 4);
        manager.updateSubtask(subtask1, 5);

        Subtask subtask2 = new Subtask("Subtask2", "example2", "DONE", 4);
        manager.updateSubtask(subtask2, 6);

        manager.reciveAllSubtasks(manager.listOfSubtask);

        Epic epic1 = new Epic("Epic1", "Update Epic", "NEW", new ArrayList<Integer>());
        manager.updateEpic(epic1, 2);
        manager.reciveAllEpics(manager.listOfEpic);

        manager.returnEpicById(2);
        manager.printSubtasksForEpic(4);
    }
}
