import java.util.ArrayList;
import java.util.List;


public class InMemoryAuctionService implements AuctionService {

	Auction a = new Auction(1000, "Broccoli", 20);
	Auction b = new Auction(2777, "Human Foot", 3);
	Auction c = new Auction(7319, "Scott's service", 1);
	Auction d = new Auction(2565, "Chess set", 50);
	
	static List<Auction> auctions = new ArrayList<Auction>();
	
	public InMemoryAuctionService() {
		auctions.add(a);
		auctions.add(b);
		auctions.add(c);
		auctions.add(d);
	}
	@Override
	public Auction[] search(String criteria) {
		Auction[] blah = new Auction[1];
		int id;
		String name;
		int bid;
		Auction returnAuction = new Auction(id, name, bid);
		if (criteria != null || criteria != "") {
			for (Auction auction : auctions) {
				if (auction.getName().equals(criteria)) {
					System.out.println(blah[1]);
					//blah[1] = 
				}
			}
		}
		return null;
	}

	@Override
	public void bid(String username, int itemId) {
		if (itemId == itemId) {
			//currentBid = currentBid + 1;
		}
		
	}
	
	public static void main(String[] args) {
		((AuctionService) auctions).search("Broccoli");
		
		
	}

}
