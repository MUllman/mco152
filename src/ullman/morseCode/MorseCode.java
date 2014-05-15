package ullman.morseCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MorseCode {

	private final Map<String, String> alphaMorse;

	public MorseCode() {
		alphaMorse = new HashMap();

		String[] alpha = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
				"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
				"W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7",
				"8", "9", " " };

		String[] code = { ".- ", "-... ", "-.-. ", "-.. ", ". ", "..-. ",
				"--. ", ".... ", ".. ", ".--- ", "-.- ", ".-.. ", "-- ", "-. ",
				"--- ", ".--. ", "--.- ", ".-. ", "... ", "- ", "..- ",
				"...- ", ".-- ", "-..- ", "-.-- ", "--.. ", "----- ", ".---- ",
				"..--- ", "...-- ", "....- ", "..... ", "-.... ", "--... ",
				"---.. ", "----.", "/ " };
		for (int i = 0; i < alpha.length; i++) {
			alphaMorse.put(alpha[i], code[i]);
			alphaMorse.put(code[i], alpha[i]);
		}

	}

	public String toMorseCode(String alphabet) {
		char[] characters = alphabet.trim().toUpperCase().toCharArray();
		StringBuilder output = new StringBuilder("");
		for (char c : characters) {
			String letter = String.valueOf(c);
			String morse = alphaMorse.get(letter);
			output.append(morse);
		}
		return output.toString().trim();
	}

	public String toPlainText(String code) {
		StringTokenizer token = new StringTokenizer(code, " ");
		ArrayList<String> mCode = new ArrayList<String>();
		while (token.hasMoreTokens()) {
			mCode.add(token.nextToken());
		}
		StringBuilder output = new StringBuilder("");
		for (String s : mCode) {
			String morse = s + " ";
			String english = alphaMorse.get(morse);
			output.append(english);
		}
		return output.toString().trim();
	}
}
