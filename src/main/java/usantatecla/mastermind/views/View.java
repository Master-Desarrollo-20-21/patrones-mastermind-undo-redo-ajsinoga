package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.*;

public abstract class View implements ControllerVisitor {
	
	public void interact(AcceptorController controller) {
		controller.accept(this);
	}

}
