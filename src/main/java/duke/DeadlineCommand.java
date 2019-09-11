package duke;

/**
 * Encapsulates a DeadlineCommand object in charge of adding a deadline task into the task list.
 */

import java.io.IOException;

public class DeadlineCommand extends Command {

    /**
     * The constructor is inherited from Command class.
     * @param fullCommand String of valid, full command input
     */
    public DeadlineCommand (String fullCommand) {
        super(fullCommand);
    }

    @Override
    /**
     * Adds a deadline task into the taskList and updates file in storage.
     * @param tasks TaskList object containing a list of existing tasks.
     * @param storage
     * @throws IOException
     */
    void execute(TaskList tasks, Storage storage) throws IOException {
        Parser parser = new Parser(fullCommand);
        tasks.addDeadline(parser.getActivityNameWithTime(),
        parser.getDeadline(), false);
        storage.updateFile(tasks);
    }
}