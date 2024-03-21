package observer;

//https://howtodoinjava.com/design-patterns/behavioral/observer-design-pattern/
import java.util.ArrayList;
import java.util.List;

interface Board {							// Subject
	void addDisplayBoard(DisplayBoard obs);
	void removeDisplayBoard(DisplayBoard obs);
	void updateDisplayBoards();
}

interface DisplayBoard {							// Observer
	void displayScore(Score score);
}

class Score {
	int runs;
	int wickets;
	double overs;
	
	public Score(int runs, int wickets, double overs) {
		this.runs = runs;
		this.wickets =  wickets;
		this.overs = overs;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	@Override
	public String toString() {
		return "Score [runs=" + runs + ", wickets=" + wickets + ", overs=" + overs + "]";
	}
}
	
class Match implements Board {		// Concrete Subject
	
	Score score;
	List<DisplayBoard> displayBoards;
	
	Match() {
		displayBoards = new ArrayList<>();
	}
	
	public void setScore(Score score) {
		this.score = score;
	}
	
	public Score getScore() {
		return score;
	}
	
	@Override
	public void addDisplayBoard(DisplayBoard obs) {
		this.displayBoards.add(obs);
	}

	@Override
	public void removeDisplayBoard(DisplayBoard obs) {
		this.displayBoards.remove(obs);
	}
	
	public void updateScore() {
		updateDisplayBoards();
	}

	@Override
	public void updateDisplayBoards() {
		for (DisplayBoard displayBoard : this.displayBoards) {
				displayBoard.displayScore(score);
		}
	}	
}

class CurrentScoreDisplay implements DisplayBoard {	// ConcreteObserver

	private Board board;
	
	public CurrentScoreDisplay(Board sub) {
		this.board = sub;
		this.board.addDisplayBoard(this);
	}
	
	@Override
	public void displayScore(Score score) {
		System.out.println(score.toString());
	}
}

class AverageScoreDisplay implements DisplayBoard {	// ConcreteObserver

	private Board board;
	
	public AverageScoreDisplay(Board sub) {
		this.board = sub;
		this.board.addDisplayBoard(this);
	}
	
	@Override
	public void displayScore(Score score) {
		System.out.println(score.toString());
	}
}

public class TestObserverPattern {

	public static void main(String[] args) {
		
		Match match = new Match();
		Score score = new Score(12,2,4.5);
		match.setScore(score);
		
		DisplayBoard cs = new CurrentScoreDisplay(match);
		DisplayBoard as = new AverageScoreDisplay(match);
		
		match.updateScore();
		
		score.setRuns(13);
		match.updateScore();
		
		match.removeDisplayBoard(as);
		
		score.setRuns(14);
		match.updateScore();
	}

}
