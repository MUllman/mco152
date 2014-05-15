package ullman.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Evaluator {

	private final TicTacToeBoard board;
	private Symbol winner;

	public Evaluator(TicTacToeBoard board) {
		this.board = board;
	}

	public void evaluate() {
		Symbol player = Symbol.X;
		for (int i = 0; i < 2; i++) {
			for (int r = 0; r < 3; r++) {
				if (player == board.getSquare(new Location(r, 0))
						&& player == board.getSquare(new Location(r, 1))
						&& player == board.getSquare(new Location(r, 2))) {
					winner = player;
				} else if (player == board.getSquare(new Location(0, r))
						&& player == board.getSquare(new Location(1, r))
						&& player == board.getSquare(new Location(2, r))) {
					winner = player;
				}

			}

			if (player == board.getSquare(new Location(0, 0))
					&& player == board.getSquare(new Location(1, 1))
					&& player == board.getSquare(new Location(2, 2))) {
				winner = player;
			} else if (player == board.getSquare(new Location(0, 2))
					&& player == board.getSquare(new Location(1, 1))
					&& player == board.getSquare(new Location(2, 0))) {
				winner = player;
			}
			player = Symbol.O;
		}

	}

	public Symbol getWinner() {
		return winner;
	}

	public List<Location> getWinningSquares() {
		if (winner == null) {
			return null;
		} else {
			Location one = null;
			Location two = null;
			Location three = null;
			for (int i = 0; i < 3; i++) {
				if (winner == board.getSquare(new Location(i, 0))
						&& winner == board.getSquare(new Location(i, 1))
						&& winner == board.getSquare(new Location(i, 2))) {
					one = new Location(i, 0);
					two = new Location(i, 1);
					three = new Location(i, 2);
				} else if (winner == board.getSquare(new Location(0, i))
						&& winner == board.getSquare(new Location(1, i))
						&& winner == board.getSquare(new Location(2, i))) {
					one = new Location(0, i);
					two = new Location(1, i);
					three = new Location(2, i);
				}
			}

			if (winner == board.getSquare(new Location(0, 0))
					&& winner == board.getSquare(new Location(1, 1))
					&& winner == board.getSquare(new Location(2, 2))) {
				one = new Location(0, 0);
				two = new Location(1, 1);
				three = new Location(2, 2);
			} else if (winner == board.getSquare(new Location(0, 2))
					&& winner == board.getSquare(new Location(1, 1))
					&& winner == board.getSquare(new Location(2, 0))) {
				one = new Location(0, 2);
				two = new Location(1, 1);
				three = new Location(2, 0);
			}
			ArrayList<Location> winningSpots = new ArrayList<Location>();
			winningSpots.add(one);
			winningSpots.add(two);
			winningSpots.add(three);
			return winningSpots;
		}
	}
}
