package ullman.tictactoe;

import org.junit.Assert;
import org.junit.Test;

public class TicTacToeBoardTest {

	@Test
	public void testFull() {
		TicTacToeBoard board = new TicTacToeBoard();
		boolean test = board.isFull();
		Assert.assertFalse(test);
	}

	@Test
	public void testSetAndGet() {
		TicTacToeBoard board = new TicTacToeBoard();
		board.setSquare(new Location(0, 0), Symbol.X);
		String X = String.valueOf(board.getSquare(new Location(0, 0)));
		String expected = "X";
		Assert.assertEquals(expected, X);

	}

	@Test
	public void testReset() {
		TicTacToeBoard board = new TicTacToeBoard();
		board.setSquare(new Location(0, 0), Symbol.X);
		board.reset();
		Assert.assertNull(board.getSquare(new Location(0, 0)));

	}

	@Test
	public void testFullTrue() {
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
		boolean test = board.isFull();
		Assert.assertTrue(test);
	}

}
