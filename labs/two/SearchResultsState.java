import java.util.Scanner;


public class SearchResultsState implements State {
	public EventLoop ELoop;
	public Auction[] auc;
	public String daString;
	
	public SearchResultsState() {
		
	}

	@Override
	public void show() {
		Scanner scan = new Scanner(System.in);
		System.out.println(daString + " , Results");
		for (Auction auction : auc) {
			if (auction.getOwner() != null) {
				System.out.println(auction.getId() + "     " + auction.getName() + "     " + auction.getCurrentBid() + "     " + auction.getOwner());
			} else {
				System.out.println(auction.getId() + "     " + auction.getName() + "     " + auction.getCurrentBid());
			}
		}
		System.out.println("Enter the item id to increase the bid by $1. If not, please enter another search value: (press enter to go back to the home page");
		String input = scan.nextLine();
		if (!input.equals("")) {
			ELoop.service.bid(daString, Integer.parseInt(input));
		}
	}
		

	@Override
	public State next() {
		return new UserHomeState();
	}
}
