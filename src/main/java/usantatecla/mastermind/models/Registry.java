package usantatecla.mastermind.models;

import java.util.List;
import java.util.ArrayList;

public class Registry {

    private List<Memento> mementos;
    private Game game;
    private int firstPrevious;

    Registry(Game game) {
        this.game = game;
        this.mementos = new ArrayList<Memento>();
        this.firstPrevious = 0;
        this.mementos.add(this.firstPrevious, this.game.createMemento());
    }

    void register() {
        for (int i = 0; i < this.firstPrevious; i++) {
            this.mementos.remove(0);
            this.firstPrevious--;            
        }
        this.mementos.add(this.firstPrevious, this.game.createMemento());
    }

    void undo() {
        this.firstPrevious++;
        this.game.setMemento(this.mementos.get(firstPrevious));        
    }

    void redo() {
        this.firstPrevious--;
        this.game.setMemento(this.mementos.get(firstPrevious));
    }

    boolean isUndoable() {
        return this.firstPrevious < this.mementos.size() - 1;
    }

    boolean isRedoable() {
        return this.firstPrevious >= 1;
    }

}
