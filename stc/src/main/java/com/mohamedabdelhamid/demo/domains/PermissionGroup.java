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
    

    @Column(name = "group_name")
    private String groupName;
    
    @OneToMany(mappedBy = "permissionGroup", cascade = CascadeType.ALL)
    private Set<Permissions> permissions;

	public PermissionGroup(Long id, String name, Set<User> users, String groupName, Set<Permissions> permissions) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
		this.groupName = groupName;
		this.permissions = permissions;
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

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Set<Permissions> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permissions> permissions) {
		this.permissions = permissions;
	}
	
	
	 public void addUserWithViewAccess(User user) {
	        UserPermission userPermission = new UserPermission(user, PermissionLevel.VIEW);
	        userPermissions.add(userPermission);
	    }
     
	 public void addUserWithEditAccess(User user) {
	        UserPermission userPermission = new UserPermission(user, PermissionLevel.EDIT);
	        userPermissions.add(userPermission);
	    }

    
}