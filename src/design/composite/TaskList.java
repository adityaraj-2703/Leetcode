package design.composite;

import java.util.ArrayList;
import java.util.List;

public class TaskList implements Task {
    private String title;
    private List<Task> taskList;

    public TaskList(String title) {
        this.title = title;
        this.taskList = new ArrayList<>();
    }

    @Override
    public String getTitle() {
        // TODO Auto-generated method stub
        return this.title;
    }

    @Override
    public void setTitle(String title) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTitle'");
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.println("Task List: " + title);
        for (Task task : taskList) {
            task.display();
        }
    }

    public void removeTaskList(Task t) {
        taskList.remove(t);
    }

    public void addTaskList(Task t) {
        this.taskList.add(t);
    }

}
