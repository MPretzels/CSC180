import java.util.HashMap;
import java.util.Map;


public class Auction {
	
	private final int id;
	private int currentBid;
	private String owner;
	private String name;
	private Map<String, Object> properties = new HashMap<String, Object>();
	
	public <T> T getProperty(String propertyName, Class<T> propertyType) {
		return (propertyType.cast(properties.get(propertyName)));
	}
	
	public Object getProperty(String propertyName) {
		return properties.get(propertyName);
	}
	
	public void setProperty(String propertyName, Object propertyValue) {
		properties.put(propertyName, propertyValue);
	}
	
	public Map<String, Object> getProperties() {
		return properties;
	}
	
	public Auction(int id, String name, int currentBid) {
		this.id = id;
		this.name = name;
		this.currentBid = currentBid;
	}
	
	public Auction(int id, String name, int currentBid, Map<String, Object> properties) {
		this.id = id;
		this.name = name;
		this.currentBid = currentBid;
		this.properties = properties;
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
	
	public void setCurrentBid(int currentBid) {
		this.currentBid = currentBid;
	}
	
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
		return this.id + " " + this.currentBid + " " + this.name + " " + this.owner + " " + this.properties;
	}
	
}
