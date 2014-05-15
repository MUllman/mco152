package ullman.dictionary;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import ullman.dictionary.Dictionary;

public class DictionaryTest {

	@Test
	public void readIn() {
		try {
			Dictionary dict = new Dictionary();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		try {
			Dictionary dict = new Dictionary();
			boolean result = dict.exists("me");
			Assert.assertTrue(result);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
