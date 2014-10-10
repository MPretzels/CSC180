import java.util.Scanner;


public class DefaultState implements State {
	private boolean user;
	public Event thisEvent;
	
	@Override
	public void show() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Hello New User! would you like to log in? (press enter to decline)");
		String input = scan.nextLine();
		if(!input.equals("")) {
			thisEvent = new Event(input, this);
			user = true;
		} else {
			user = false;
		}
		
	}

	@Override
	public State next() {
		if(user) {
			return new UserHomeState();
		} else {
			return null;
		}
	}
	
}
