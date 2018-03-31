
public class Winner {
	
	private String id;
	private String username;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String toString(){
		return "id: " +this.id + " winner: " +this.username + ", ";
	}
	
	

}
