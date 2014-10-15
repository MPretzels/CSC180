import java.util.ArrayList;
import java.util.List;


public class ContainsPredicate implements Predicate<Auction> {

	private String criteria;
	
	public ContainsPredicate(String criteria) {
		this.criteria = criteria;
	}
	@Override
	public boolean evaluate(Auction t) {
		return t.getName().contains(criteria);
	}
	
}
