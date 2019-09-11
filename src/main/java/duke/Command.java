package duke;

/**
 * Encapsulates a Command object that is able to represent different types of command.
 */

import java.io.IOException;

public class Command {

    String fullCommand;

    /**
     * Creates a new Command object containing the full, valid input command.
     * @param fullCommand String of full, valid input command.
     */
    public Command(String fullCommand) {
        this.fullCommand = fullCommand;
    }

    /**
     * Executes actions according different command type.
     * @param tasks TaskList object containing a list of existing tasks.
     * @param storage
     * @throws IOException
     */
    void execute(TaskList tasks, Storage storage) throws IOException {}
}
