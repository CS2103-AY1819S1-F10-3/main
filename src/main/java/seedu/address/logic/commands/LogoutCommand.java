package seedu.address.logic.commands;

import seedu.address.logic.CommandHistory;
import seedu.address.model.Model;

/**
 * Log the user out of the application.
 */
public class LogoutCommand extends Command {
    public static final String COMMAND_WORD = "logout";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Log out of the application. "
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Successfully logged out.";

    @Override
    public CommandResult execute(Model model, CommandHistory history) {
        model.commitUserLoggedOutSuccessfully();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
