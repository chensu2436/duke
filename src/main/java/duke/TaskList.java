package duke;

/**
 * Encapsulates a TaskList object, which contains the task list,
 * and has operations to add/delete/done tasks in the list.
 */

import java.util.ArrayList;

public class TaskList {

    /** 1 attribute.
     * list represents the task list.
     */
    private ArrayList<Task> list;

    /**
     * The constructor takes in no parameter and creates an empty list.
     */
    public TaskList() {
        list = new ArrayList<>();
    }

    /**
     * The constructor takes in an ArrayList of task objects and creates a list of
     * the same content as the parameter.
     * @param tasks an ArrayList of task object.
     */
    public TaskList(ArrayList<Task> tasks) {
        list = tasks;
    }

    /**
     * Prints out the tasks in the list currently.
     */
    void showTasks() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    /**
     * Prints out the tasks with keyword in the list currently.
     */
    void findTask(String keyword) {
        System.out.println("Here are the matching tasks in your list:");
        int i = 0;
        for (Task task : list) {
            if (task.toString().contains(keyword)) {
                System.out.println((i + 1) + ". " + task);
                i++;
            }
        }
    }

    /**
     * Adds a new task into the list and prints out the message.
     * @param newTask newly created task object.
     */
    private void addAndPrint(Task newTask) {
        list.add(newTask);
        System.out.println("Got it. I've added this task: \n  "
                + newTask + "\nNow you have " + list.size() + " tasks in the list.");
    }

    /**
     * Creates a new Todo object and adds it into the list.
     * @param activityName String of take name.
     * @param isDone true if the task is done, or false otherwise.
     */
    void addTodo(String activityName, boolean isDone) {
        Task newTask = new Todo(activityName,isDone);
        addAndPrint(newTask);
    }

    /**
     * Creates a new Deadline object and adds it into the list.
     * @param activityName String of take name.
     * @param deadline String of deadline time.
     * @param isDone true if the task is done, or false otherwise.
     */
    void addDeadline(String activityName, String deadline, boolean isDone) {
        Task newTask = new Deadline(activityName, isDone, deadline);
        addAndPrint(newTask);
    }

    /**
     * Creates a new Event object and adds it into the list.
     * @param activityName String of take name.
     * @param time String of activity time.
     * @param isDone true if the task is done, or false otherwise.
     */
    void addEvent(String activityName, String time, boolean isDone) {
        Task newTask = new Event(activityName,isDone, time);
        addAndPrint(newTask);
    }

    /**
     * Marks the task of the specified index to "done".
     * @param idx integer that represents the index of the task in the command.
     */
    void doneTask(int idx) {
        list.get(idx - 1).markAsDone();
        System.out.println("Nice! I've marked this task as done: \n  "
                + list.get(idx - 1));
    }

    /**
     * Deletes the task in the command from the task list.
     * @param idx integer that represents the index of the task in the command.
     */
    void deleteTask(int idx) {
        Task removed = list.remove(idx - 1);
        System.out.println("Noted. I've removed this task: \n  " + removed
                + "\nNow you have " + list.size() + " tasks in the list.");
    }

    /**
     * Returns an ArrayList of the current task list.
     * @return an ArrayList of the current task list.
     */
    ArrayList<Task> getTaskList() {
        return list;
    }
}
