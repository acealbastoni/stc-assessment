package com.mohamedabdelhamid.demo.domains;


import jakarta.persistence.*;
@Entity
public class Permissions {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "permission_level")
	    private PermissionLevel permissionLevel;

	    @ManyToOne
	    @JoinColumn(name = "group_id")
	    private PermissionGroup group;

	    // Constructors
	    public Permissions() {
	    }

	    public Permissions(User user, PermissionLevel permissionLevel) {
	        this.user = user;
	        this.permissionLevel = permissionLevel;
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public PermissionLevel getPermissionLevel() {
			return permissionLevel;
		}

		public void setPermissionLevel(PermissionLevel permissionLevel) {
			this.permissionLevel = permissionLevel;
		}

		public PermissionGroup getGroup() {
			return group;
		}

		public void setGroup(PermissionGroup group) {
			this.group = group;
		}
	    
	
}