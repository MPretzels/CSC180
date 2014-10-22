import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


public class InMemoryAuctionService implements AuctionService {

	Auction a = new Auction(1000, "broccoli", 20, "Green Veggie");
	Auction b = new Auction(2777, "human Foot", 3, "singular attachment of a biped creature");
	Auction c = new Auction(7319, "scott's service", 1, "Various techniques");
	Auction d = new Auction(2565, "chess set", 50, "knowledgable game set");
	
	static Map<Integer, Auction> auctions = new HashMap<Integer, Auction>();
	
	public InMemoryAuctionService() {
		auctions.put(a.getId(), a);
		auctions.put(b.getId(), b);
		auctions.put(c.getId(), c);
		auctions.put(d.getId(), d);
	}
	@Override
	public Auction[] search(String criteria) {
		Stack<String> operators = new Stack<String>();
		Stack<Predicate> predicate = new Stack<Predicate>();
		String[] splitter = criteria.split(" ");
		
		for(String s : splitter) {
			if (s.equals("and") || s.equals("or")) {
				if (s.equals("or")) {
					while (!operators.empty() && operators.peek().equals("and")) {
						operators.pop();
						ContainsPredicate predA = (ContainsPredicate) predicate.pop();
						ContainsPredicate predB = (ContainsPredicate) predicate.pop();
						AndPredicate and = new AndPredicate(predA, predB);
						predicate.push(and);
					}
					operators.push(s);
				} else {
					operators.push(s);
				}
			}
			if (!s.equals("and") && !s.equals("or")) {
				ContainsPredicate cp = new ContainsPredicate(s);
				predicate.push(cp);
			}
		}
		while (!operators.empty()) {
			operators.pop();
			OrPredicate OP = new OrPredicate(predicate.pop(), predicate.pop());
			predicate.push(OP);
		}
		ArrayList<Auction> stuff = new ArrayList<Auction>();
		stuff.addAll(CollectionUtils.filter(auctions.values(), predicate.pop()));
		
		return stuff.toArray(new Auction[1]);
	}

	@Override
	public void bid(String username, Integer itemId) {
		try {
			if (itemId != 0) {
				for(Auction auction : auctions.values()) {
					if(auction.getId() == itemId) {
						auction.setCurrentBid(auction.getCurrentBid() + 1);
						auction.setOwner(username);
					}
				}
			}
		} catch (Exception ex) {
			System.out.println("Id or username not found");
		}
		
	}
	
	@Override
	public Auction create(Auction a) {
		int counter = 0;
		Auction stuffz = null;
		for (Auction auction : auctions.values()) {
			 stuffz = new Auction(a.getName(), a.getCurrentBid(), a.getDescription());
			auctions.put(a.getId(), stuffz);
			counter++;
		}
		return stuffz;
	}
	@Override
	public Auction retreive(Integer id) {
		try {
			if (id != null) {
				return auctions.get(id);
			}
		} catch (NullPointerException ex) {
			System.err.println("Item not found");
		}
		return null;
	}
	@Override
	public Auction update(Integer id, Auction a) {
		try {
			auctions.put(id, a);
		} catch (NullPointerException ex) {
			System.err.println("ID not found");
		}
		return auctions.get(id);
	}
	@Override
	public void delete(Integer id) {
		if (id != null) {
			auctions.remove(id);
		}
	}

}
