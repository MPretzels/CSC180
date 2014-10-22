import java.util.LinkedList;
import java.util.Queue;


public class EventLoop {
	public Queue<Event> daQueue = new LinkedList<Event>();
	InMemoryAuctionService service = new InMemoryAuctionService();
	
	public void begin() {
		Queue<Event> doStuff = daQueue;
		
		DefaultState DState = new DefaultState();
		UserHomeState UHState = new UserHomeState();
		SearchResultsState SRState;
		AuctionCreateState ACState = new AuctionCreateState();
		
		DState.show();
		if(DState.next() != null) {
			DState.thisEvent.setCurrentEvent(UHState);
			if (DState.next() != null) {
				doStuff.add(DState.thisEvent);
				UHState.disString = DState.thisEvent.getUsername();
			}
		}
		Auction[] auctions = null;
		for (int i = 0; i < doStuff.size();) {
			DState = new DefaultState();
			UHState = new UserHomeState();
			SRState = new SearchResultsState();
			ACState = new AuctionCreateState();
			
		}
		
		DState.show();
		if (DState.next() != null) {
			DState.thisEvent.setCurrentEvent(UHState);
			if (DState.next() != null) {
				doStuff.add(DState.thisEvent);
				UHState.disString = DState.thisEvent.getUsername();
			}
		}
		
		if (doStuff.peek() != null) {
			Event daEvent = doStuff.poll();
			State daState = daEvent.getCurrentEvent();
			if (daState instanceof UserHomeState) {
				((UserHomeState)daState).disString = daEvent.getUsername();
				((UserHomeState)daState).loop = this;
				daState.show();
				auctions = ((UserHomeState)daState).auc;
				daEvent.setCurrentEvent(new SearchResultsState());
				SearchResultsState search = (SearchResultsState) daEvent.getCurrentEvent();
				search.auc = auctions;
			} else if (daState instanceof SearchResultsState) {
				((SearchResultsState)daState).daString = daEvent.getUsername();
				((SearchResultsState)daState).ELoop = this;
				daState.show();
				daEvent.setCurrentEvent(new UserHomeState());
			}
			
			if (daState.next() != null) {
				doStuff.add(daEvent);
			}
		}
		
	}
	
	public static void main(String[] args) {
		EventLoop e = new EventLoop();
		e.begin();
	}
}

