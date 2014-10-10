
public class Event {
	private final String username;
	private State daState;
	
	public Event(String username, State currentEvent) {
		this.username = username;
		this.daState = currentEvent;
	}
	
	public State getCurrentEvent() {
		return daState;
	}
	
	public void setCurrentEvent(State currentEvent) {
		daState = currentEvent;
	}
	
	public String getUsername() {
		return username;
	}
}
