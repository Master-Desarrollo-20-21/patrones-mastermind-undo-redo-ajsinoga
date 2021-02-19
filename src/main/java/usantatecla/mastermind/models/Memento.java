package usantatecla.mastermind.models;

import java.util.List;

import usantatecla.mastermind.types.Color;

public class Memento {

    private int attempt;
    private List<Color> colors;

    public Memento(Game game) { 
        this.attempt = game.getAttempts();
    }

	int getAttempts() {
		return this.attempt;
	}

}
