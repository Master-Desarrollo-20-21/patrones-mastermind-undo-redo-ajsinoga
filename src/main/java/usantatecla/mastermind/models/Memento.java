package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

public class Memento {

    private List<ProposedCombination> proposedCombinations;

    public Memento(List<ProposedCombination> proposedCombinations) { 
        this.proposedCombinations = new ArrayList<ProposedCombination>();
        for (int i = 0; i < proposedCombinations.size(); i++) {
            if (proposedCombinations.get(i) != null) {
                this.proposedCombinations.add(i, proposedCombinations.get(i).copy());
            }
        }
    }

    public int getAttempts() {
        return this.proposedCombinations.size();
    }

    public List<ProposedCombination> getProposedCombinations() {
        return this.proposedCombinations;
    }

    public List<Result> getResults(SecretCombination secretCombination) {
        List<Result> results = new ArrayList<Result>();
        for (int i = 0; i < getAttempts(); i++) {
            results.add(i, secretCombination.getResult(proposedCombinations.get(i)));
        }
        return results;
    }

}
