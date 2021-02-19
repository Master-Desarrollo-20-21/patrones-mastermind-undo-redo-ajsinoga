package usantatecla.mastermind.controllers;

import java.util.List;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

public class PlayController extends Controller implements AcceptorController {

    private ProposalController proposalController;
    private UndoController undoController;
    private RedoController redoController;

    public PlayController(Session session) {
        super(session);
        this.proposalController = new ProposalController(session);
        this.undoController = new UndoController(session);
        this.redoController = new RedoController(session);
    }
    
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

	public int getAttempts() {
		return this.proposalController.getAttempts();
	}

	public Error addProposedCombination(List<Color> colors) {
		return this.proposalController.addProposedCombination(colors);
	}

    public void save(List<Color> colors) {
        this.proposalController.save(colors);
	}

	public boolean isWinner() {
		return this.session.isWinner();
	}

	public boolean isLooser() {
		return this.session.isLooser();
	}

	public List<Color> getColors(int position) {
		return this.proposalController.getColors(position);
	}

	public int getBlacks(int i) {
		return this.proposalController.getBlacks(i);
	}

	public int getWhites(int i) {
		return this.proposalController.getWhites(i);
	}

    public void undo() {
        this.undoController.undo();
    }

    public boolean isUndoable() {
        return undoController.isUndoable();
    }

    public void redo() {
        this.redoController.redo();
    }

    public boolean isRedoable() {
        return this.redoController.isRedoable();
    }
    
}
