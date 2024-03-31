package com.mohamedabdelhamid.demo.domains;

import jakarta.persistence.*;
@Entity
public class Space {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    private String name;
	    
	    @ManyToOne
	    @JoinColumn(name = "permission_group_id")
	    private PermissionGroup permissionGroup;


	    // Constructors, getters, and setters
		public Space(Long id, String name, PermissionGroup permissionGroup) {
			super();
			this.id = id;
			this.name = name;
			this.permissionGroup = permissionGroup;
		}
		public Space() {
			
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

		public PermissionGroup getPermissionGroup() {
			return permissionGroup;
		}

		public void setPermissionGroup(PermissionGroup permissionGroup) {
			this.permissionGroup = permissionGroup;
		}

	    
}
