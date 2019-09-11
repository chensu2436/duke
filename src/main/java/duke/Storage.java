package duke;

/**
 * Encapsulates a Storage object to deal with loading tasks from the file
 * and saving tasks in the file.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

public class Storage {

    /** 1 attribute.
     * filePath represents a string of file path of the file that stores
     * data of the task list.
     */
    private String filePath;

    /**
     * The constructor takes in filePath and creates a new storage object.
     * @param filePath the string representing the file path of the stored task list.
     */
    Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Returns an ArrayList of tasks loaded from the file.
     * @return an ArrayList of tasks loaded from the file.
     * @throws FileNotFoundException if the file cannot be found by the path.
     */
    ArrayList<Task> load() throws FileNotFoundException {
        FileReader fr = new FileReader(filePath);
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner s = new Scanner(fr);

        while (s.hasNext()) {
            String line = s.nextLine();
            String[] part = line.split("/");

            // Status is either done or not done.
            String status = part[1];
            boolean isDone;
            isDone = status.equals("✓");

            // Checks the type of task.
            switch (part[0]) {
            case "T":
                tasks.add(new Todo(part[2], isDone));
                break;
            case "D":
                tasks.add(new Deadline(part[2], isDone, part[3]));
                break;
            case "E":
                tasks.add(new Event(part[2], isDone, part[3]));
                break;
            default:
                assert false : part[0];
            }
        }
        return tasks;
    }

    /**
     * Saves the tasks in the list whenever there is any change.
     */
    void updateFile(TaskList tasks) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        for (Task task : tasks.getTaskList()) {
            fw.write(task.storageFormat() + "\n");
            fw.flush();
        }
    }
}
