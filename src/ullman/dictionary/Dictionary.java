package ullman.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {

	private final Map<String, String> map;

	public Dictionary() throws FileNotFoundException {
		map = new HashMap<String, String>();
		Scanner scanner;

		scanner = new Scanner(new File("OWL.txt"));

		while (scanner.hasNext()) {
			map.put(scanner.next(), scanner.nextLine());
		}
		scanner.close();
	}

	public boolean exists(String word) {
		return map.containsKey(word);
	}

	public Map<String, String> getWordList() {
		return map;
	}

	public Iterator<String> iterator() {
		return map.keySet().iterator();
	}

	public String getDefinition(String word) {
		return map.get(word);
	}

}
