package backend.classes;

import java.util.List;

import frontend.EHRRunner;
import frontend.GenericRunner;

public class User {
	private String FirstName; 
	private String LastName; 
	private String Email; 
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}


	public User(List<String> headerList, List<Object> dataList) {
		// TODO Auto-generated constructor stub
	}


	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public GenericRunner accept(EHRRunner ehrRunner) {
<<<<<<< HEAD
		return null; 
=======
>>>>>>> b0a2518785746ab0f3d47568c484a04d341f20c6
		
	}
	

}