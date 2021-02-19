package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.utils.Menu;

public class PlayMenu extends Menu {

    PlayMenu(PlayController playController) {
        this.addCommand(new ProposalCommand(playController));
        this.addCommand(new UndoCommand(playController));
        this.addCommand(new RedoCommand(playController));
    }
    
}
