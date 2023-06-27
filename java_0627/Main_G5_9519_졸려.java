package java_0627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_G5_9519_Á¹·Á {

	// abcdef -> afbecd -> adfcbe -> aedbfc -> acefdb
	// sarma -> saamr -> srama -> sarma

	static int X;
	static String word;
	static ArrayList<String> words = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		X = Integer.parseInt(in.readLine());
		word = in.readLine();

		words.add(word);

		String wordBeforeBlinking = word;
		while (words.size() <= X) {
			wordBeforeBlinking = getWordBeforeBlinking(wordBeforeBlinking);

			if (wordBeforeBlinking.equals(word))
				break;
			words.add(wordBeforeBlinking);
		}

		System.out.println(words.get(words.size() > X ? X : X % words.size()));
	}

	private static String getWordBeforeBlinking(String word) {
		int len = word.length();
		String result = "";

		for (int i = 0; i < len; i += 2) {
			result += word.charAt(i);
		}
		for (int i = len % 2 == 0 ? len - 1 : len - 2; i >= 0; i -= 2) {
			result += word.charAt(i);
		}

		return result;
	}

}
