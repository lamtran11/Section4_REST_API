package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class exportLongestString {
	
	public static void exportLongestString (int inputNum) {
		
		Scanner scanner = new Scanner(System.in);
		
		List<String> inputList = new ArrayList<>();
		List<String> longestString = new ArrayList<>();
		
		int maxLength = 0;
		
		for(int i = 0; i < inputNum; i++) {
			
			System.out.print(i + " string index - pls input: ");
			inputList.add(scanner.nextLine());
		}
		
		for(String input : inputList) {
			
			if(input.length() > maxLength) {
				
				maxLength = input.length();
				longestString.clear();
                longestString.add(input);
                
			} else if (input.length() == maxLength) {
				longestString.add(input);
			}
		}	
		
		System.out.println("最長の文字列: " + String.join(", ", longestString));		
	}
	
	public static void main(String[] args) throws Exception {
			
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("文字列の個数を入力してください");
		int inputNum = scanner.nextInt();
		
		exportLongestString(inputNum);
		
		scanner.close();
	}
	
}

