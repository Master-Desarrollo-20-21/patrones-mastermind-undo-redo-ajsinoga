package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.MessageView;

public class UndoCommand extends Command {

    UndoCommand(PlayController playController) {
        super(MessageView.UNDO_COMMAND.getMessage(), playController);
    }

    @Override
    protected void execute() {
        this.playController.undo();
    }

    @Override
    protected boolean isActive() {
        return this.playController.isUndoable();
    }
    
}
