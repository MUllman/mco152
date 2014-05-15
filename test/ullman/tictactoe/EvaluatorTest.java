package ullman.tictactoe;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class EvaluatorTest {

	@Test
	public void testWinnerDiagnalRight() {
		TicTacToeBoard board = new TicTacToeBoard();
		board.setSquare(new Location(0, 0), Symbol.X);
		board.setSquare(new Location(0, 1), Symbol.O);
		board.setSquare(new Location(0, 2), Symbol.X);
		board.setSquare(new Location(1, 0), Symbol.O);
		board.setSquare(new Location(1, 1), Symbol.X);
		board.setSquare(new Location(1, 2), Symbol.O);
		board.setSquare(new Location(2, 0), Symbol.X);
		board.setSquare(new Location(2, 1), Symbol.O);
		board.setSquare(new Location(2, 2), Symbol.X);
		Evaluator eval = new Evaluator(board);
		eval.evaluate();
		Symbol symbol = eval.getWinner();
		Symbol expected = Symbol.X;
		Assert.assertEquals(symbol, expected);
	}

	@Test
	public void testWinnerDiagnalLeft() {
		TicTacToeBoard board = new TicTacToeBoard();
		board.setSquare(new Location(0, 0), Symbol.O);
		board.setSquare(new Location(0, 1), Symbol.O);
		board.setSquare(new Location(0, 2), Symbol.X);
		board.setSquare(new Location(1, 0), Symbol.O);
		board.setSquare(new Location(1, 1), Symbol.X);
		board.setSquare(new Location(1, 2), Symbol.O);
		board.setSquare(new Location(2, 0), Symbol.X);
		board.setSquare(new Location(2, 1), Symbol.O);
		board.setSquare(new Location(2, 2), Symbol.X);
		Evaluator eval = new Evaluator(board);
		eval.evaluate();
		Symbol symbol = eval.getWinner();
		Symbol expected = Symbol.X;
		Assert.assertEquals(symbol, expected);
	}

	@Test
	public void testWinnerAcross() {
		TicTacToeBoard board = new TicTacToeBoard();
		board.setSquare(new Location(0, 0), Symbol.O);
		board.setSquare(new Location(0, 1), Symbol.O);
		board.setSquare(new Location(0, 2), Symbol.O);
		board.setSquare(new Location(1, 0), Symbol.O);
		board.setSquare(new Location(1, 1), Symbol.X);
		board.setSquare(new Location(1, 2), Symbol.X);
		board.setSquare(new Location(2, 0), Symbol.X);
		board.setSquare(new Location(2, 1), Symbol.O);
		board.setSquare(new Location(2, 2), Symbol.X);
		Evaluator eval = new Evaluator(board);
		eval.evaluate();
		Symbol symbol = eval.getWinner();
		Symbol expected = Symbol.O;
		Assert.assertEquals(symbol, expected);
	}

	@Test
	public void testGetWinningSquares() {
		TicTacToeBoard board = new TicTacToeBoard();
		board.setSquare(new Location(0, 0), Symbol.O);
		board.setSquare(new Location(0, 1), Symbol.O);
		board.setSquare(new Location(0, 2), Symbol.X);
		board.setSquare(new Location(1, 0), Symbol.O);
		board.setSquare(new Location(1, 1), Symbol.X);
		board.setSquare(new Location(1, 2), Symbol.O);
		board.setSquare(new Location(2, 0), Symbol.O);
		board.setSquare(new Location(2, 1), Symbol.X);
		board.setSquare(new Location(2, 2), Symbol.O);
		Evaluator eval = new Evaluator(board);
		eval.evaluate();
		ArrayList<Location> list = (ArrayList<Location>) eval
				.getWinningSquares();
		ArrayList<Location> expected = new ArrayList<Location>();
		expected.add(new Location(0, 0));
		expected.add(new Location(1, 0));
		expected.add(new Location(2, 0));
		StringBuilder sb = new StringBuilder();
		for (Location l : list) {
			sb.append(l.getX());
			sb.append(l.getY());
		}
		StringBuilder stbu = new StringBuilder();
		for (Location e : expected) {
			stbu.append(e.getX());
			stbu.append(e.getY());
		}
		String e = expected.toString();
		Assert.assertEquals(sb.toString(), stbu.toString());

	}

}
