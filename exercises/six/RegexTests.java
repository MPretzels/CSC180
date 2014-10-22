import static org.junit.Assert.*;

import org.junit.Test;


public class RegexTests {

	@Test
	// This test should return a sequence of numbers
	public void testNumbers() {
		RegexPractice r = new RegexPractice();
		String math = "2+3-5*4/8";
		System.out.println(r.extractNumbers(math));
	}
	
	@Test
	// This test should return a sequence of operators
	public void testOperators() {
		RegexPractice r = new RegexPractice();
		String math = "2+3-5*4/8";
		System.out.println(r.extractOperators(math));
	}
	
	@Test
	// This test should return a sequence of emails
	public void testEmails() {
		RegexPractice r = new RegexPractice();
		String emails = "blahblah@gamil.net is awesome like tutu@hotmail.com";
		System.out.println(r.extractEmails(emails));
	}
	
	@Test
	// This test should return a string of text
	public void testLists() {
		RegexPractice r = new RegexPractice();
		String lists = "<li>what is this text?</li> this is an example of the li tag";
		System.out.println(r.extractListBody(lists));
	}

	
}
