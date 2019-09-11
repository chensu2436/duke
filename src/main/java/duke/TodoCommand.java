package duke;

/**
 * Encapsulates a TodoCommand object in charge of adding a todo task into the tasklist.
 */

import java.io.IOException;

public class TodoCommand extends Command {

    /**
     * The constructor is inherited from Command class.
     * @param fullCommand String of valid, full command input
     */
    public TodoCommand (String fullCommand) {
        super(fullCommand);
    }

    @Override
    /**
     * Adds a todo task into the taskList and updates file in storage.
     * @param tasks TaskList object containing a list of existing tasks.
     * @param storage
     * @throws IOException
     */
    void execute(TaskList tasks, Storage storage) throws IOException {
        Parser parser = new Parser(fullCommand);
        tasks.addTodo(parser.getActivityNameWithoutTime(),
        false);
        storage.updateFile(tasks);

    }
}