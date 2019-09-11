package duke;

/**
 * Encapsulates a DoneCommand object in charge of marking the target task as done.
 */

import java.io.IOException;

public class DoneCommand extends Command {

    /**
     * The constructor is inherited from Command class.
     * @param fullCommand String of valid, full command input
     */
    public DoneCommand (String fullCommand) {
        super(fullCommand);
    }

    @Override
    /**
     * Marks the task with given index to be done and updates the storage file.
     * @param tasks TaskList object containing a list of existing tasks.
     * @param storage
     * @throws IOException
     */
    void execute(TaskList tasks, Storage storage) throws IOException {
        Parser parser = new Parser(fullCommand);
        tasks.doneTask(parser.getIndex());
        storage.updateFile(tasks);
    }
}
