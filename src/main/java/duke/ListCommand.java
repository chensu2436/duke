package duke;

/**
 * Encapsulates a ListCommand object in charge of listing existing tasks in the list.
 */

public class ListCommand extends Command {

    /**
     * The constructor is inherited from Command class.
     * @param fullCommand String of valid, full command input
     */
    public ListCommand (String fullCommand) {
        super(fullCommand);
    }

    @Override
    /**
     * Lists existing tasks in the tasks list.
     * @param tasks TaskList object containing a list of existing tasks.
     * @param storage
     */
    void execute(TaskList tasks, Storage storage) {
        tasks.showTasks();
    }
}
