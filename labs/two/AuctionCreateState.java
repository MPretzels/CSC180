import java.util.Scanner;


public class AuctionCreateState implements State {
	InMemoryAuctionService imas = new InMemoryAuctionService();

	@Override
	public void show() {
		Scanner randy = new Scanner(System.in);
		System.out.println("Please enter the name of the item you wish to add");
		String name = randy.nextLine();
		System.out.println("Please enter a description for the item to be added");
		String desc = randy.nextLine();
		System.out.println("Please enter the starting price for the item to be added");
		int startPrice = randy.nextInt();
		for (int i = 0; i < imas.auctions.size(); i++) {
			
		}
		int i = 0;
		for (Auction auction : imas.auctions.values()) {
			i++;
		}
		
		Auction auc = new Auction(i, name, startPrice, desc);
		imas.auctions.put(auc.getId(), auc);
		next();
	}

	@Override
	public State next() {
		return new UserHomeState();
	}

}
