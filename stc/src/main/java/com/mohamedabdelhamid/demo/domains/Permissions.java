package com.mohamedabdelhamid.demo.domains;
import jakarta.persistence.*;
@Entity
public class Permissions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String userEmail;

	private String permissionLevel;

	@ManyToOne
	@JoinColumn(name = "group_id")
	private PermissionGroup group;

	// Constructors, getters, and setters
	public Permissions(Long id, String userEmail, String permissionLevel, PermissionGroup group) {
		super();
		this.id = id;
		this.userEmail = userEmail;
		this.permissionLevel = permissionLevel;
		this.group = group;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPermissionLevel() {
		return permissionLevel;
	}

	public void setPermissionLevel(String permissionLevel) {
		this.permissionLevel = permissionLevel;
	}

	public PermissionGroup getGroup() {
		return group;
	}

	public void setGroup(PermissionGroup group) {
		this.group = group;
	}

}