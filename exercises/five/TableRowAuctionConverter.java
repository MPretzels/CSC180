
public class TableRowAuctionConverter implements Converter<Auction> {

	Auction a =  new Auction(1232, "Stuffs", 10, "the best");
	@Override
	public Auction parse(String fromString) {
		return null;
	}

	@Override
	public String format(Auction fromObject) {
		String f = fromObject.getId() + "\t" + fromObject.getName() + "\t" + "$" + fromObject.getCurrentBid() + "\t" + fromObject.getDescription();
		return f;
	}

}
