import java.util.Scanner;


public class UserHomeState implements State {
	private boolean user;
	EventLoop loop;
	public Auction[] auc;
	public String disString;
	String input;
	
	@Override
	public void show() {
		Scanner scan = new Scanner(System.in);
		System.out.println(disString + " Enter a search value. If you want to create an item press 1 (press enter to log out)");
		input = scan.nextLine().toLowerCase();
		if (input.equals("1")) {
			AuctionCreateState acs = new AuctionCreateState();
			acs.show();
			show();
		} 
		if (!input.equals("")) {
			user = true;
			auc = loop.service.search(input);
		} else {
			user = false;
		}
	}
	
	@Override
	public State next() {
		if (user) {
			return new SearchResultsState();
		} else {
			return null;
		}
	}
	
	public String[] parseStuff(String parseInput) {
		parseInput.split("or");
		return new String[1];
	}
}
