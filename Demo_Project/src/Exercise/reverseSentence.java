package Exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class reverseSentence {
	
	public static String reverseSentence(String inputSentence) {
		
		String[] words = inputSentence.split(" ");
		List<String> sentences = new ArrayList<>();
		
		Collections.addAll(sentences, words);
		
		Collections.reverse(sentences);
		
		String reverseSentence = String.join(" ", sentences);
		
		return reverseSentence;
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("文字列を入力してください。");
		
        String sentence = scanner.nextLine();
        System.out.println(reverseSentence(sentence));
    }

	
	
}