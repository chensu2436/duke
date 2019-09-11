package duke;

/**
 * Encapsulates a EventCommand object in charge of adding a event task into the task list.
 */

import java.io.IOException;

public class EventCommand extends Command {

    /**
     * The constructor is inherited from Command class.
     * @param fullCommand String of valid, full command input
     */
    public EventCommand (String fullCommand) {
        super(fullCommand);
    }

    @Override
    /**
     * Adds a event task into the taskList and updates file in storage.
     * @param tasks TaskList object containing a list of existing tasks.
     * @param storage
     * @throws IOException
     */
    void execute(TaskList tasks, Storage storage) throws IOException {
        Parser parser = new Parser(fullCommand);
        tasks.addEvent(parser.getActivityNameWithTime(),
        parser.getTime(), false);
        storage.updateFile(tasks);
    }
}