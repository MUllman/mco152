package ullman.tictactoe;

public class TicTacToeBoard {

	private final Symbol[][] board;

	public TicTacToeBoard() {
		board = new Symbol[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = null;
			}
		}
	}

	public void reset() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = null;
			}
		}
	}

	public boolean isFull() {
		boolean isFull = true;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == null) {
					return isFull = false;
				}
			}
		}
		return isFull;
	}

	public void setSquare(Location location, Symbol symbol) {
		board[location.getX()][location.getY()] = symbol;
	}

	public Symbol getSquare(Location location) {
		return board[location.getX()][location.getY()];

	}

}
