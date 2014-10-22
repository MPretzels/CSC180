
public interface AuctionService {
	
	public Auction[] search(String criteria);
	public void bid(String username, Integer itemId);
	
	Auction create(Auction obj);
	Auction retreive(Integer id);
	Auction update(Integer id, Auction obj);
	void delete(Integer id);
	
}
