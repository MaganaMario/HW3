package application;

import java.util.ArrayList;

/**
 * The UserLightweightDTO (Data Transfer Object) class represents a 
 * answer in the database, but it removes unnecessary data in order to 
 * allow less memory intensive queries. 
 */
public class UserLightweightDTO {
	private String userName;
    private String fullName;
    private String email;
    private ArrayList<String> roles;
	
	public UserLightweightDTO(String userName, String fullName, String email, ArrayList<String> roles) {
		this.userName = userName;
		this.fullName = fullName;
		this.email = email;
		this.roles = roles;
	}

	public String getUserName() { return userName; }
	public String getFullName() { return fullName; }
	public String getEmail() { return email; }
	public ArrayList<String> getRoles() { return roles; }
}
