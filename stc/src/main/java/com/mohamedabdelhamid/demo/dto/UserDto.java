package com.mohamedabdelhamid.demo.dto;

public class UserDto {
    private String email;
    private String accessLevel;
    
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDto(String email, String accessLevel) {
		super();
		this.email = email;
		this.accessLevel = accessLevel;
	}
    
    
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}
      
}