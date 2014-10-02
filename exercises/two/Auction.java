import javax.sound.sampled.AudioFileFormat.Type;


public class Auction {
	
	private final int id;
	public final int currentBid;
	public String owner;
	private String name;
	
	public Auction(int id, String name, int currentBid) {
		this.id = id;
		this.name = name;
		this.currentBid = currentBid;
	}
	
	public int getId() {
		return id;
	}
	
	//public void setId(int id) {
		//this.id = id;
	//}
	
	public int getCurrentBid() {
		return currentBid;
	}
	
	//public void setCurrentBid(int currentBid) {
		//this.currentBid = currentBid;
	//}
	
	public String getOwner() {
		return owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int hashCode() {
		return name.hashCode();
	}
	
	public boolean equals(Object obj) {
		return equals((Auction)obj);
	}
	
	public boolean equals(Auction a) {
		return name.equals(a.name);
	}
	
	public String toString() {
		return "";
		
	}
	
}
