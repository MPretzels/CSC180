import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexPractice {
	
	public ArrayList extractOperators(String equation) {
		ArrayList operators = new ArrayList();
		for (int i = 0; i < equation.length(); i++) {
			if (equation.charAt(i) == '+' || equation.charAt(i) == '-' || equation.charAt(i) == '/' || equation.charAt(i) == '*') {
				operators.add(equation.charAt(i - 1));
			}
		}
		operators.toString();
		return operators;
	}
	
	public ArrayList extractNumbers(String equation) {
		ArrayList numbers = new ArrayList();
		for (int i = 0; i < equation.length(); i++) {
			if (equation.charAt(i) == '+' || equation.charAt(i) == '-' || equation.charAt(i) == '/' || equation.charAt(i) == '*') {
				numbers.add(equation.charAt(i));
			}
		}
		numbers.toString();
		return numbers;
	}
	
	public ArrayList extractEmails(String emails) {
		ArrayList addresses = new ArrayList();
		Pattern p = Pattern.compile("\\b[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}\\b");
		Matcher m = p.matcher(emails);
		while(m.find()) {
			addresses.add(m.group());
		}
		addresses.toString();
		return addresses;
	}
	
	public ArrayList extractListBody(String list) {
		ArrayList listText = new ArrayList();
		Pattern p = Pattern.compile("<li>(.+?)</li>");
		Matcher m = p.matcher(list);
		m.find();
		listText.add(m.group(1));
		listText.toString();
		return listText;
	}
	
	public static void main(String[] args) {
		RegexTests t = new RegexTests();
		t.testEmails();
	}
}
