package ullman.morseCode;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {

	@Test
	public void testToMorseCode() {
		MorseCode mC = new MorseCode();
		String code;
		code = mC.toMorseCode("I hope this works ");
		String expected = ".. / .... --- .--. . / - .... .. ... / .-- --- .-. -.- ...";
		Assert.assertEquals(code, expected);
	}

	@Test
	public void testToPlainText() {
		MorseCode mC = new MorseCode();
		String code = mC
				.toPlainText(".--. .-.. . .- ... . / .-- --- .-. -.- / - .... .. ... / - .. -- .");
		String expected = "PLEASE WORK THIS TIME";
		Assert.assertEquals(code, expected);
	}

	@Test
	public void testIfEmptyStringCrashesToCode() {
		MorseCode mC = new MorseCode();
		String code;
		code = mC.toMorseCode("   ");
		String expected = "";
		Assert.assertEquals(code, expected);
	}

	@Test
	public void testIfEmptyStringCrashesToText() {
		MorseCode mC = new MorseCode();
		String code = mC.toPlainText("");
		String expected = "";
		Assert.assertEquals(code, expected);
	}

}
