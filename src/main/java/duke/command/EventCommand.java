package duke.command;

/**
 * Encapsulates a EventCommand object in charge of adding a event task into the task list.
 */

import duke.Parser;
import duke.Storage;
import duke.TaskList;

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
    public
    /**
     * Adds a event task into the taskList and updates file in storage.
     * @param tasks TaskList object containing a list of existing tasks.
     * @param storage
     * @throws IOException
     */
    String execute(TaskList tasks, Storage storage) throws IOException {
        Parser parser = new Parser(fullCommand);
        String message = tasks.addEvent(parser.getActivityNameWithTime(),
        parser.getTime(), false);
        storage.updateFile(tasks);
        return message;
    }
}