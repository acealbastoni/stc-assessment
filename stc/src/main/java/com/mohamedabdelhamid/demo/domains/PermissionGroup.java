package com.mohamedabdelhamid.demo.domains;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;

@Entity
public class PermissionGroup {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @OneToMany(mappedBy = "permissionGroup")
    private Set<User> users = new HashSet<>();

    public PermissionGroup(Long id, String name, Set<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
	}
    public PermissionGroup() {

	}

    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	
    
    
//    
//    private String groupName;
//    
//    @OneToMany(mappedBy = "permissionGroup")
//    private Set<Item> items;
//
//    // Constructors, getters, and setters
//	public PermissionGroup(Long id, String groupName, Set<Item> items) {
//		super();
//		this.id = id;
//		this.groupName = groupName;
//		this.items = items;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getGroupName() {
//		return groupName;
//	}
//
//	public void setGroupName(String groupName) {
//		this.groupName = groupName;
//	}
//
//	public Set<Item> getItems() {
//		return items;
//	}
//
//	public void setItems(Set<Item> items) {
//		this.items = items;
//	}
//    
//    
//    
    
}