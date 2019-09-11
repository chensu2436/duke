package duke;

/**
 * Encapsulates a Deadline object that inherits from Task class and
 * stores task name, status and deadline time.
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

class Deadline extends Task {

    /**
     * 1 additional parameter
     * deadline represents a String representation of deadline time of the task.
     */
    private String deadline;

    /**
     * The constructor takes in taskName, done, and deadline to create a Deadline object.
     * @param taskName String of task name
     * @param isDone true if the task is done, or false otherwise.
     * @param deadline String representation of deadline time of the task.
     */
    Deadline(String taskName, boolean isDone, String deadline) {
        super(taskName, isDone);
        this.deadline  = deadline;
    }

    @Override
    /**
     * Returns a String representation of the task.
     * @returna String showing the status and the task name of a Deadline object.
     */
    public String toString() {
        if (isDone) {
            return "[D][✓]" + taskName + "(by:" + deadline + ")";
        } else {
            return "[D][✗]" + taskName + "(by:" + deadline + ")";
        }
    }

    /**
     * Returns a Data object which is converted from the String deadline time.
     * @return a Data object which is converted from the String deadline time.
     */
    private Date convertDateTime() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date converted;
        try {
            converted = formatter.parse(deadline);
        } catch  (ParseException e) {
            return null;
        }
        return converted;
    }

    /**
     * Returns a String of representation of the task that is to be recorded in the file.
     * @return String of representation of the task that is to be recorded in the file.
     */
    public String storageFormat() {
        if (isDone) {
            return "D/✓/" + taskName + "/" + deadline;
        } else {
            return "D/✗/" + taskName + "/" + deadline;
        }
    }
}
