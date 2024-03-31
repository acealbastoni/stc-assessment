package com.mohamedabdelhamid.demo.dto;

import java.util.List;

//SpaceRequestDto.java
public class SpaceRequestDto {
 private String name;
 private String groupName;
 private List<UserDto> users;
 

public SpaceRequestDto(String name, String groupName, List<UserDto> users) {
	super();
	this.name = name;
	this.groupName = groupName;
	this.users = users;
}

 
 
 
public SpaceRequestDto() {
	super();
	// TODO Auto-generated constructor stub
}




public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGroupName() {
	return groupName;
}
public void setGroupName(String groupName) {
	this.groupName = groupName;
}
public List<UserDto> getUsers() {
	return users;
}
public void setUsers(List<UserDto> users) {
	this.users = users;
}
 // getters and setters
}