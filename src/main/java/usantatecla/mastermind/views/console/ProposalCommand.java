package usantatecla.mastermind.views.console;

import java.util.List;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.mastermind.views.MessageView;

public class ProposalCommand extends Command {

    ProposalCommand(PlayController playController) {
        super(MessageView.PROPOSED_COMBINATION.getMessage(), playController);
    }    

    @Override
    protected void execute() {
        if (!this.playController.isLooser()) {
            this.propose(playController);      
        }
    }

    private void propose(PlayController playController) {
        Error error;
        List<Color> colors;
		do {
			colors = new ProposedCombinationView(playController).read();
			error = playController.addProposedCombination(colors);
			if (error != null) {
				new ErrorView(error).writeln();
			}
		} while (error != null);
        playController.save(colors);
    }

    @Override
    protected boolean isActive() {
        return true;
    }
}
