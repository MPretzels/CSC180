import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InMemoryAuctionService implements AuctionService {

	Auction a = new Auction(1000, "Broccoli", 20);
	Auction b = new Auction(2777, "Human Foot", 3);
	Auction c = new Auction(7319, "Scott's service", 1);
	Auction d = new Auction(2565, "Chess set", 50);
	
	static Map<Integer, Auction> auctions = new HashMap<Integer, Auction>();
	
	public InMemoryAuctionService() {
		auctions.put(a.getId(), a);
		auctions.put(b.getId(), b);
		auctions.put(c.getId(), c);
		auctions.put(d.getId(), d);
	}
	@Override
	public Auction[] search(String criteria) {
		List<Auction> blah = new ArrayList<Auction>();
		if (criteria != null || criteria.equals("")) {
			for (Auction auction : auctions.values()) {
				if (auction.getName().contains(criteria)) {
					blah.add(auction);
				}
			}
		}
		return blah.toArray(new Auction[1]);
	}

	@Override
	public Auction bid(String username, Integer itemId) {
		if (itemId != null) {
			for(Auction auction : auctions.values()) {
				if(auction.getId() == itemId) {
					auction.setCurrentBid(auction.getCurrentBid() + 1);
					auction.setOwner(username);
					return auction;
				}
			}
		}
		return null;
		
	}
	
	public static void main(String[] args) {
		((AuctionService) auctions).search("Broccoli");
		
		
	}
	@Override
	public Auction create(Auction a) {
		Auction stuffz = new Auction(
				a.getId(),	a.getName(), a.getCurrentBid(), a.getProperties());
		auctions.put(a.getId(), stuffz);
		return stuffz;
	}
	@Override
	public Auction retreive(Integer id) {
		return (Auction) auctions.get(id);
	}
	@Override
	public Auction update(Integer id, Auction a) {
		auctions.put(id, a);
		return retreive(id);
	}
	@Override
	public void delete(Integer id) {
		auctions.remove(id);
	}

}
