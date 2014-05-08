package ullman.checkers;

import java.util.ArrayList;
import java.util.List;

/**
 * This implementation of a game of Checkers should match
 * http://simple.wikipedia.org/wiki/Checkers
 * 
 * How to play Checkers: https://www.youtube.com/watch?v=SuQY1_fCVsA
 */
public class CheckerBoard {

	public static final int WIDTH = 8;
	public static final int HEIGHT = 8;
	private final Piece[][] board;

	public CheckerBoard() {
		this.board = new Piece[HEIGHT][WIDTH];
	}

	public Piece getPiece(final int x, final int y) {
		return board[y][x];
	}

	public void setPiece(final int x, final int y, final Piece piece) {
		board[y][x] = piece;
	}

	public void removePiece(final int x, final int y) {
		setPiece(x, y, null);
	}

	/**
	 * Returns true if the x,y coordinate is within the 8x8 board, otherwise
	 * false
	 */
	public boolean isOnBoard(final int x, final int y) {
		return x >= 0 && x <= 7 && y >= 0 && y <= 7;
	}

	/**
	 * Returns true if the square is null, otherwise false
	 */
	public boolean isEmptySquare(final int x, final int y) {
		return getPiece(x, y) == null;
	}

	/**
	 * Removes all pieces from the board
	 */
	public void clear() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				removePiece(i, j);
			}
		}
	}

	/**
	 * Sets the board to a starting configuration
	 */
	public void resetNewGame() {
		clear();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 0 || i == 2) {
					if (j % 2 == 1) {
						setPiece(j, i, Piece.WHITE_MAN);
					}
				}

				if (i == 1) {
					if (j % 2 == 0) {
						setPiece(j, i, Piece.WHITE_MAN);
					}
				}

				if (i == 5 || i == 7) {
					if (j % 2 == 0) {
						setPiece(j, i, Piece.RED_MAN);
					}
				}
				if (i == 6) {
					if (j % 2 == 1) {
						setPiece(j, i, Piece.RED_MAN);
					}
				}
			}
		}
	}

	@Override
	/**
	 * Returns a String representation of the board. Each row of the board should be on it's own line.
	 * A dash "-" represents an empty square. Pieces should be displayed using the .toString() method
	 * of the piece class.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (isEmptySquare(j, i)) {
					sb.append("-");
				} else {
					Piece p = getPiece(j, i);
					sb.append(p.toString());
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	/**
	 * Do the Move, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. If the piece is now on their "King's Row", then promote the piece
	 * should be promoted to a King
	 */
	public void execute(final Move move) {
		Piece p = getPiece(move.getX1(), move.getY1());
		removePiece(move.getX1(), move.getY1());
		if (p.equals(Piece.WHITE_MAN) && move.getY2() == 7) {
			p = Piece.WHITE_KING;
		}
		if (p.equals(Piece.RED_MAN) && move.getY2() == 0) {
			p = Piece.RED_KING;
		}
		setPiece(move.getX2(), move.getY2(), p);
	}

	/**
	 * Do the Jump, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. Remove the piece from captureX, captureY as well. If the piece is now
	 * on their "King's Row", then promote the piece should be promoted to a
	 * King
	 */
	public void execute(final Jump jump) {
		Piece p = getPiece(jump.getX1(), jump.getY1());
		removePiece(jump.getX1(), jump.getY1());
		removePiece(jump.getCaptureX(), jump.getCaptureY());
		if (p.equals(Piece.WHITE_MAN) && jump.getY2() == 7) {
			p = Piece.WHITE_KING;
		}
		if (p.equals(Piece.RED_MAN) && jump.getY2() == 0) {
			p = Piece.RED_KING;
		}
		setPiece(jump.getX2(), jump.getY2(), p);
	}

	/**
	 * Returns a list of all possible moves from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal move then
	 * return an empty list
	 */
	public List<Move> getMoves(final int x, final int y) {
		ArrayList<Move> moves = new ArrayList<Move>();
		if (isEmptySquare(x, y)) {
			return moves;
		} else {
			if (getPiece(x, y).equals(Piece.WHITE_MAN)) {
				if (isOnBoard(x - 1, y + 1) && isEmptySquare(x - 1, y + 1)) {
					moves.add(new Move(x, y, x - 1, y + 1));
				}
				if (isOnBoard(x + 1, y + 1) && isEmptySquare(x + 1, y + 1)) {
					moves.add(new Move(x, y, x + 1, y + 1));
				}
			} else {
				if (getPiece(x, y).equals(Piece.RED_MAN)) {
					if (isOnBoard(x - 1, y - 1) && isEmptySquare(x - 1, y - 1)) {
						moves.add(new Move(x, y, x - 1, y - 1));
					}
					if (isOnBoard(x + 1, y - 1) && isEmptySquare(x + 1, y - 1)) {
						moves.add(new Move(x, y, x + 1, y - 1));
					}
				} else {
					if (getPiece(x, y).equals(Piece.WHITE_KING)
							|| getPiece(x, y).equals(Piece.RED_KING)) {
						if (isOnBoard(x - 1, y - 1)
								&& isEmptySquare(x - 1, y - 1)) {
							moves.add(new Move(x, y, x - 1, y - 1));
						}
						if (isOnBoard(x + 1, y - 1)
								&& isEmptySquare(x + 1, y - 1)) {
							moves.add(new Move(x, y, x + 1, y - 1));
						}
						if (isOnBoard(x - 1, y + 1)
								&& isEmptySquare(x - 1, y + 1)) {
							moves.add(new Move(x, y, x - 1, y + 1));
						}
						if (isOnBoard(x + 1, y + 1)
								&& isEmptySquare(x + 1, y + 1)) {
							moves.add(new Move(x, y, x + 1, y + 1));
						}
					}
				}
			}
		}
		return moves;
	}

	/**
	 * Returns a list of all possible jumps from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal jump then
	 * return an empty list
	 */
	public List<Jump> getJumps(final int x, final int y) {// not done
		ArrayList<Jump> jumps = new ArrayList<Jump>();
		if (isEmptySquare(x, y)) {
			return jumps;
		} else {
			if (getPiece(x, y).equals(Piece.WHITE_MAN)) {
				if (isOnBoard(x - 1, y + 1) && !isEmptySquare(x - 1, y + 1)) {
					if (getPiece(x - 1, y + 1).equals(Piece.RED_KING)
							|| getPiece(x - 1, y + 1).equals(Piece.RED_MAN)) {
						if (isEmptySquare(x - 2, y + 2)) {
							jumps.add(new Jump(x, y, x - 1, y + 1, x - 2, y + 2));
						}
					}
				}
				if (isOnBoard(x + 1, y + 1) && !isEmptySquare(x + 1, y + 1)) {
					if (getPiece(x + 1, y + 1).equals(Piece.RED_KING)
							|| getPiece(x + 1, y + 1).equals(Piece.RED_MAN)) {
						if (isEmptySquare(x + 2, y + 2)) {
							jumps.add(new Jump(x, y, x + 1, y + 1, x + 2, y + 2));
						}
					}
				}
			} else {
				if (getPiece(x, y).equals(Piece.RED_MAN)) {
					if (isOnBoard(x - 1, y - 1) && !isEmptySquare(x - 1, y - 1)) {
						if (getPiece(x - 1, y - 1).equals(Piece.WHITE_KING)
								|| getPiece(x - 1, y - 1).equals(
										Piece.WHITE_MAN)) {
							if (isEmptySquare(x - 2, y - 2)) {
								jumps.add(new Jump(x, y, x - 1, y - 1, x - 2,
										y - 2));
							}
						}
					}
					if (isOnBoard(x + 1, y - 1) && !isEmptySquare(x + 1, y - 1)) {
						if (getPiece(x + 1, y - 1).equals(Piece.WHITE_KING)
								|| getPiece(x + 1, y - 1).equals(
										Piece.WHITE_MAN)) {
							if (isEmptySquare(x + 2, y - 2)) {
								jumps.add(new Jump(x, y, x + 1, y - 1, x + 2,
										y - 2));
							}
						}
					}
				} else {
					if (getPiece(x, y).equals(Piece.RED_KING)) {
						if (isOnBoard(x - 1, y - 1)
								&& !isEmptySquare(x - 1, y - 1)) {
							if (getPiece(x - 1, y - 1).equals(Piece.WHITE_KING)
									|| getPiece(x - 1, y - 1).equals(
											Piece.WHITE_MAN)) {
								if (isEmptySquare(x - 2, y - 2)) {
									jumps.add(new Jump(x, y, x - 1, y - 1,
											x - 2, y - 2));
								}
							}
						}
						if (isOnBoard(x + 1, y - 1)
								&& !isEmptySquare(x + 1, y - 1)) {
							if (getPiece(x + 1, y - 1).equals(Piece.WHITE_KING)
									|| getPiece(x + 1, y - 1).equals(
											Piece.WHITE_MAN)) {
								if (isEmptySquare(x + 2, y - 2)) {
									jumps.add(new Jump(x, y, x + 1, y - 1,
											x + 2, y - 2));
								}
							}
						}
						if (isOnBoard(x - 1, y + 1)
								&& !isEmptySquare(x - 1, y + 1)) {
							if (getPiece(x - 1, y + 1).equals(Piece.WHITE_KING)
									|| getPiece(x - 1, y + 1).equals(
											Piece.WHITE_MAN)) {
								if (isEmptySquare(x - 2, y + 2)) {
									jumps.add(new Jump(x, y, x - 1, y + 1,
											x - 2, y + 2));
								}
							}
						}
						if (isOnBoard(x + 1, y + 1)
								&& !isEmptySquare(x + 1, y + 1)) {
							if (getPiece(x + 1, y + 1).equals(Piece.WHITE_KING)
									|| getPiece(x + 1, y + 1).equals(
											Piece.WHITE_MAN)) {
								if (isEmptySquare(x + 2, y + 2)) {
									jumps.add(new Jump(x, y, x + 1, y + 1,
											x + 2, y + 2));
								}
							}
						}
					} else {
						if (getPiece(x, y).equals(Piece.WHITE_KING)) {
							if (isOnBoard(x - 1, y - 1)
									&& !isEmptySquare(x - 1, y - 1)) {
								if (getPiece(x - 1, y - 1).equals(
										Piece.RED_KING)
										|| getPiece(x - 1, y - 1).equals(
												Piece.RED_MAN)) {
									if (isEmptySquare(x - 2, y - 2)) {
										jumps.add(new Jump(x, y, x - 1, y - 1,
												x - 2, y - 2));
									}
								}
							}
							if (isOnBoard(x + 1, y - 1)
									&& !isEmptySquare(x + 1, y - 1)) {
								if (getPiece(x + 1, y - 1).equals(
										Piece.RED_KING)
										|| getPiece(x + 1, y + 1).equals(
												Piece.RED_MAN)) {
									if (isEmptySquare(x + 2, y - 2)) {
										jumps.add(new Jump(x, y, x + 1, y - 1,
												x + 2, y - 2));
									}
								}
							}
							if (isOnBoard(x - 1, y + 1)
									&& !isEmptySquare(x - 1, y + 1)) {
								if (getPiece(x - 1, y + 1).equals(
										Piece.RED_KING)
										|| getPiece(x - 1, y + 1).equals(
												Piece.RED_MAN)) {
									if (isEmptySquare(x - 2, y + 2)) {
										jumps.add(new Jump(x, y, x - 1, y + 1,
												x - 2, y + 2));
									}
								}
							}
							if (isOnBoard(x + 1, y + 1)
									&& !isEmptySquare(x + 1, y + 1)) {
								if (getPiece(x + 1, y + 1).equals(
										Piece.RED_KING)
										|| getPiece(x + 1, y + 1).equals(
												Piece.RED_MAN)) {
									if (isEmptySquare(x + 2, y + 2)) {
										jumps.add(new Jump(x, y, x + 1, y + 1,
												x + 2, y + 2));
									}
								}
							}
						}
					}
				}
			}
		}
		return jumps;
	}

}
