package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.YesNoDialog;

class ResumeView {

	void interact(ResumeController resumeController) {
		boolean isNewGame = new YesNoDialog().read(MessageView.RESUME.getMessage());
		if (isNewGame) {
			resumeController.reset();
		}
		else {
			resumeController.next();
		}		
	}
	
}
