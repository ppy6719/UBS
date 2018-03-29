import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.Scanner;


public class WordCount {

	public static void main(String[] args) {

		//String text = "This is a statement, and so is this.";
		String text;

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a sentence, then press RETURN key to proceed:");
		text = sc.nextLine();

		System.out.println("Processing sentence: " + text);
		countAndDisplayWords(text);
	}


	private static String removeChar(String word, String ch) {

		String newWord = "";
		int inSup = word.indexOf(ch);

		if (inSup >= 0)
			newWord = word.substring(0, inSup) + word.substring(inSup + 1);
		else
			newWord = word;

		return newWord;
	}


	private static void countAndDisplayWords(String text) {

		Map<String, Integer> counter = new HashMap<>();
		String word, newWordTemp, newWord;
		Integer currentCount;

		// Count each word
		StringTokenizer stringTokenizer = new StringTokenizer(text, " ");
		while (stringTokenizer.hasMoreElements()) {
			word = stringTokenizer.nextToken();

			newWordTemp = removeChar(word, ".");
			newWord = removeChar(newWordTemp, ",");

			currentCount = counter.get(newWord.toLowerCase());
			if (currentCount == null) {
				currentCount = 0;
			}

			++currentCount;
			counter.put(newWord.toLowerCase(), currentCount);
		}

		//
		// Print the results report
		// ------------------------
		// Rescan the text in order to report the words count in their occuring order in the sentence
		//
		Map<String, Integer> counted = new HashMap<>();
		stringTokenizer = new StringTokenizer(text, " ");
		while (stringTokenizer.hasMoreElements()) {
			word = stringTokenizer.nextToken();

			newWordTemp = removeChar(word, ".");
			newWord = removeChar(newWordTemp, ",");

			currentCount = counter.get(newWord.toLowerCase());
			if (counted.get(newWord.toLowerCase()) == null) {
				System.out.println(newWord + " - " + currentCount);
				counted.put(newWord.toLowerCase(), 0);
			}
		}
	}
}

