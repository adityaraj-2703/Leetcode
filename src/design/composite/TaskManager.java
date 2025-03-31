package design.composite;

public class TaskManager {
    public static void main(String[] args) {
        Task simpletask1 = new SimpleTask("complete coding");
        Task simpletask2 = new SimpleTask("write documentation");

        TaskList projectTasks = new TaskList("Project Tasks");
        projectTasks.addTaskList(simpletask1);
        projectTasks.addTaskList(simpletask2);

        TaskList phase1Tasks = new TaskList("Phase1  tasks");
        phase1Tasks.addTaskList(new SimpleTask("design"));
        phase1Tasks.addTaskList(new SimpleTask("implementation"));

        projectTasks.addTaskList(phase1Tasks);
        projectTasks.display();

    }

}
