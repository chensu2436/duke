package duke;

/**
 * Encapsulates aa Event object that inherits from Task class and
 * stores task name, status and event time.
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

class Event extends Task {

    /**
     * 1 additional parameter
     * deadline represents a String representation of event time.
     */
    private String time;

    /**
     * The constructor takes in taskName, done, and time to create aa Event object.
     * @param taskName String of task name
     * @param isDone true if the task is done, or false otherwise.
     * @param time String representation of event time.
     */
    Event(String taskName, boolean isDone, String time) {
        super(taskName, isDone);
        this.time = time;
    }

    @Override
    /**
     * Returns a String representation of the task.
     * @returna String showing the status and the task name of an Event object.
     */
    public String toString() {
        if (isDone) {
            return "[E][✓]" + taskName + "(at:" + time + ")";
        } else {
            return "[E][✗]" + taskName + "(at:" + time + ")";
        }
    }

    /**
     * Returns a Data object which is converted from the String event time.
     * @return a Data object which is converted from the String event time.
     */
    private Date convertDateTime() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date converted;
        try {
            converted = formatter.parse(time);
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
            return "E/✓/" + taskName + "/" + time;
        } else {
            return "E/✗/" + taskName + "/" + time;
        }
    }
}
