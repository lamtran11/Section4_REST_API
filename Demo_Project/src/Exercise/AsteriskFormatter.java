package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AsteriskFormatter  {
	
	public static void main(String[] args) throws InterruptedException {
		
		// abc,def,ghi => ***abc***, ***def***, ***ghi***
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("文字列を入力してください。");
		String input = sc.nextLine();
		
		
		List<String> result = new ArrayList<>();
		
		String[] parts = input.split(",");
		
		for (String str: parts) {
			result.add(str);
		}
		
		for (String str: result) {
			
			String asterFormat = "***" + str + "***";
			
			System.out.println(asterFormat);
			
			Thread.sleep(1000);
		}
		
		sc.close();
	}
}