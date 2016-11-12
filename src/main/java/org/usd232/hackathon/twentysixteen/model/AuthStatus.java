package org.usd232.hackathon.twentysixteen.model;

public class AuthStatus {
	private boolean authenticated;
	private String name;
	
	public AuthStatus(){
	    
	}
    
    public AuthStatus(boolean authenticated, String name){
        this.authenticated = authenticated;
        this.name = name;
    }
    
    public AuthStatus(String name){
        this.name = name;
    }
    
    public AuthStatus(boolean authenticated){
        this.authenticated = authenticated;
    }

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
