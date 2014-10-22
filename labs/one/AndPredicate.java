
public class AndPredicate implements Predicate<Auction> {

	private Predicate<Auction> first;
	private Predicate<Auction> second;
	
	public AndPredicate(Predicate a, Predicate b) {
		this.setF(a);
		this.setS(b);
	}
	
	public Predicate getF() {
		return first;
	}
	
	public void setF(Predicate first) {
		this.first = first;
	}
	
	public Predicate getS() {
		return second;
	}
	
	public void setS(Predicate second) {
		this.second = second;
	}
	
	@Override
	public boolean evaluate(Auction t) {
		return first.evaluate(t) && second.evaluate(t);
	}

}
