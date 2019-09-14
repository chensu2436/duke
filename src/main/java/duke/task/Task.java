package duke.task;

/**
 * Encapsulates a Task object which stores activity name, status (done or not done).
 */

public class Task {

    /** 2 attribute.
     * tasName represents the String of task name.
     * done is true if the task is done, or false otherwise.
     */
    String taskName;
    boolean isDone;
    boolean isDeleted;

    /**
     * The constructor takes in a String of taskName and a boolean variable
     * to construct a Task object.
     * @param taskName a String of task / activity name.
     * @param done true if the task is done or false otherwise.
     */
    Task(String taskName, boolean done) {
        this.taskName = taskName;
        this.isDone = done;
        isDeleted = false;
    }

    /**
     * Changes the status of the task when a "done" command is executed.
     */
    public void markAsDone() {
        isDone = true;
    }

    public void markAsDeleted() {
        isDeleted = true;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    @Override
    /**
     * Returns a String of representation of the task.
     * @return a String showing the status and the task name.
     */
    public String toString() {
        if (isDone) {
            return "[✓]" + taskName;
        } else {
            return "[✗]" + taskName;
        }
    }

    /**
     * Returns a dummy string.
     * @return a dummy string.
     */
    public String storageFormat() {
        return "";
    }
}