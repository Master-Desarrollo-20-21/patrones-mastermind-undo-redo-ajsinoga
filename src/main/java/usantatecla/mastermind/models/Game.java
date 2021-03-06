package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

import usantatecla.mastermind.types.Color;

public class Game {

	static final int MAX_ATTEMPTS = 10;

	private SecretCombination secretCombination;

	private List<ProposedCombination> proposedCombinations;

	private List<Result> results;

	private int attempts;

	public Game() {
		this.reset();
	}

	public void reset() {
		this.secretCombination = new SecretCombination();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
		this.attempts = 0;
	}

	public void addProposedCombination(List<Color> colors) {
		ProposedCombination proposedCombination = new ProposedCombination(colors);
		this.proposedCombinations.add(this.attempts, proposedCombination);
		this.results.add(this.attempts, this.secretCombination.getResult(proposedCombination));
		this.attempts++;
	}

	public boolean isLooser() {
		return this.attempts == Game.MAX_ATTEMPTS;
	}
	
	public boolean isWinner() {
		if (this.attempts > 0) {
			return this.results.get(this.attempts-1).isWinner();
		}
		return false;
	}

	public int getAttempts() {
		return this.attempts;
	}

	public List<Color> getColors(int position) {
		return this.proposedCombinations.get(position).colors;
	}

	public int getBlacks(int position) {
		return this.results.get(position).getBlacks();
	}

	public int getWhites(int position) {
		return this.results.get(position).getWhites();
	}

	public int getWidth() {
		return Combination.getWidth();
	}

	public Memento createMemento() {
		return new Memento(this.proposedCombinations);
	}

	public void setMemento(Memento memento) {
		this.attempts = memento.getAttempts();
		this.proposedCombinations = memento.getProposedCombinations();
		this.results = memento.getResults(this.secretCombination);
	}

}
