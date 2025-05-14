
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum State {
    Completed,
    Pending,
}

public class Task {

    private String name;
    private int id;
    private State taskState;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public State getTaskState() {
        return taskState;
    }

    public void setTaskState(State taskState) {
        this.taskState = taskState;
    }

    static int idIncrement(List<Task> tasks) {
        return tasks.size() + 1;
    }

    static void removeTask(List<Task> tasks, String name) {

        int i;
        for (i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).name.equals(name)) {
                tasks.remove(i);
                System.out.println("Task " + tasks.get(i).name + " was removed successfully.");
                return;
            }
        }
        System.out.println("Task was not found.");
    }

    static void displayTasks(List<Task> tasks) {
        System.out.printf("Tasks Available");

        for (Task task : tasks) {
            System.out.printf("\n\t%d. %s(%s)", task.id, task.name, task.taskState.toString());
        }
    }

    static void markTaskDone(String name, List<Task> tasks) {

        int i;
        for (i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).name.equals(name)) {
                tasks.get(i).setTaskState(State.Completed);
                System.out.printf("Task %s was successfully Completed.", name);
                return;
            }
        }
        System.out.println("Task " + name + " Doesn't exist.");
    }

    public Task(String name, int id) {
        this.name = name;
        this.id = id;
        this.taskState = State.Pending;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to To-do-List Console App");
        List<Task> tasks = new ArrayList<>();

        while (true) {
            System.out.printf(
                    "\nAvailable Operations\n\t1. Create a task\n\t2. View tasks\n\t3. Delete tasks\n\t4. Mark task as done\n\t5. Exit\n\n");
            System.out.println("Enter your Operation: ");
            String op = sc.nextLine();

            switch (op) {
                case "1": {
                    System.out.printf("Enter the task name: ");
                    String task = sc.nextLine();
                    if (task == "") {
                        System.out.println("Invalid task");
                        break;
                    }
                    Task newTask = new Task(task, Task.idIncrement(tasks));
                    tasks.add(newTask);
                    System.out.println("Creating task...");
                    System.out.println("Task added successfully.");
                }

                    break;

                case "2": {
                    Task.displayTasks(tasks);
                }
                    break;

                case "3": {
                    System.out.printf("Enter the task to be deleted: ");
                    String task = sc.nextLine();
                    Task.removeTask(tasks, task);
                }
                    break;
                case "4": {
                    System.out.printf("Enter the task completed");
                    String task = sc.nextLine();
                    markTaskDone(task, tasks);
                }
                    break;

                case "5": {
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                }

                default: {
                    System.out.println("Option not found");
                }
                    break;
            }
        }
    }
}
