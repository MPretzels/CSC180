import java.util.ArrayList;
import java.util.List;


public class ContainsPredicate implements Predicate<Auction> {

	private String criteria;
	
	public ContainsPredicate(String criteria) {
		this.criteria = criteria;
	}
	@Override
	public boolean evaluate(Auction t) {
		
		boolean evaluating = false;
		
		if(criteria.contains("or")) {
			String[] splitting = criteria.split("or");
			for (int i = 0; i < splitting.length; i++) {
				
			}
		}
		
		if (criteria.contains("and")) {
			String[] splitting = criteria.split("and");
		}
		return t.getName().contains(criteria) || t.getDescription().contains(criteria);
	}
	
}
