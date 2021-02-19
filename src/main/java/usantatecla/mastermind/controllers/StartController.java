package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

public class StartController extends Controller implements AcceptorController {

	public StartController(Session session) {
		super(session);
	}
	
	public void start() {
		this.session.next();
	}
		
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}

}
