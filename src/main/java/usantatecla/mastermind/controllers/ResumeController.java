package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

public class ResumeController extends Controller implements AcceptorController {

	public ResumeController(Session session) {
		super(session);
	}
	
	public void reset() {
		this.session.reset();	
	}
	
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}

}
