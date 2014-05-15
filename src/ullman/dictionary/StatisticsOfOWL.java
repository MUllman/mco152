package ullman.dictionary;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;

public class StatisticsOfOWL {

	private final Map<String, String> words;
	private final Iterator iter1;
	private final Iterator iter2;
	private final double[] percentage = new double[26];
	private final int[] letters = new int[26];
	private final char[] abc = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
			'W', 'X', 'Y', 'Z' };

	public StatisticsOfOWL(Map<String, String> words, Iterator iter1,
			Iterator iter2) {
		this.words = words;
		this.iter1 = iter1;
		this.iter2 = iter2;
	}

	private void getLetterAmount() {
		while (iter1.hasNext()) {
			char[] letter = ((String) iter1.next()).toCharArray();
			for (int i = 0; i < abc.length; i++) {
				for (char c : letter) {
					if (c == abc[i]) {
						letters[i] += 1;
					}
				}
			}

		}

	}

	private void getPercentage() {
		double[] numAppears = new double[26];
		while (iter2.hasNext()) {
			String word = (String) iter2.next();
			char[] letter = word.toCharArray();
			for (int i = 0; i < abc.length; i++) {
				boolean inWord = false;
				for (char c : letter) {
					if (c == abc[i]) {
						inWord = true;
					}
				}
				if (inWord) {
					numAppears[i] += 1;
				}
			}
		}

		for (int i = 0; i < percentage.length; i++) {
			double percent = numAppears[i] * 100 / words.size();
			percentage[i] = percent;
		}
	}

	@Override
	public String toString() {
		getLetterAmount();
		getPercentage();
		String info = "";
		DecimalFormat formatter = new DecimalFormat("#0.00");
		for (int i = 0; i < abc.length; i++) {
			info += abc[i] + "\t" + letters[i] + "\t"
					+ formatter.format(percentage[i]) + "%\n";
		}
		return info;
	}

	public static void main(String[] args) {
		try {
			Dictionary dictionary = new Dictionary();
			StatisticsOfOWL statistics = new StatisticsOfOWL(
					dictionary.getWordList(), dictionary.iterator(),
					dictionary.iterator());
			System.out.println(statistics.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
