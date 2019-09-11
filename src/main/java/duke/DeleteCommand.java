package duke;

/**
 * Encapsulates a DeleteCommand object in charge of deleting the target task from the list.
 */

import java.io.IOException;

public class DeleteCommand extends Command {

    /**
     * The constructor is inherited from Command class.
     * @param fullCommand String of valid, full command input
     */
    public DeleteCommand (String fullCommand) {
        super(fullCommand);
    }

    @Override
    /**
     * Deletes the task with given index from the list and updates the storage file.
     * @param tasks TaskList object containing a list of existing tasks.
     * @param storage
     * @throws IOException
     */
    void execute(TaskList tasks, Storage storage) throws IOException {
        Parser parser = new Parser(fullCommand);
        tasks.deleteTask(parser.getIndex());
        storage.updateFile(tasks);
    }
}