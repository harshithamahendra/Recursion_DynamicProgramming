/*
 * Given a number, find if the number is colorful. a number is colorful if the product of the digits in each of its substring is not equal 
 * to any of the substrings. Else, the number is not colorful. Example, 236 is not colorful since
 *  substrings of 236 is 2,3,6,23,36 and 2*3, is equal to one of the substrings, i.e., 6. Where as 263 is colorful since 2*6
 *  or 6*3 is not equal to any of its substrings. 
 */
import java.util.*;
import java.io.*;
public class substring {
	public static void main(String[] args) throws IOException{
		int product; 
		int flag = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a number");
		String number = br.readLine();
		if(number.length() <= 1){
			System.out.println("Enter a number with more than 1 digit");
			return;
		}
		Set<String> list = substrings(number);
		for(String s : list)
			System.out.println(s);
		for(String word : list){
			if(word.length() < number.length() && word.length() > 1){
				product = findProduct(word);
				if(list.contains(String.valueOf(product)))
					flag = 1;
			}
		}
		
		if(flag == 0)
			System.out.println("Number is colorful");
		else
			System.out.println("Number is not colorful");
	}
	
	/*
	 * Returns substrings for the argument string.
	 */
	public static Set<String> substrings(String string){
		if(string.length() <= 1){
			Set<String> list = new HashSet<String>();
			list.add(string);
			return list;
		}
		else{
			Set<String> list = substrings(string.substring(0,string.length() - 1));
			for(int i = string.length() - 1;i >= 0;i--)
				list.add(string.substring(i));
			return list;
		}
	}
	/*
	 * Returns product of characters in a given word
	 */
	public static int findProduct(String word){
		int prod = Integer.parseInt(word.substring(0,1));
		for(int i = 1;i < word.length();i++)
			prod *= Integer.parseInt(word.substring(i, i + 1));
		return prod;
	}
}
