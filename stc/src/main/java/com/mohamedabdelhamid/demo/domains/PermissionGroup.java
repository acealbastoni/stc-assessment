package com.mohamedabdelhamid.demo.domains;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "permission_groups")
public class PermissionGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_name", nullable = false)
    private String groupName;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Permissions> permissions = new HashSet<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "space_id")
    private Space space;

    // Constructors, getters, and setters

    public PermissionGroup() {
    }

    public PermissionGroup(String groupName) {
        this.groupName = groupName;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }
    public Set<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permissions> permissions) {
        this.permissions = permissions;
    }

 // Method to add a user with edit access
    public void addUserWithEditAccess(User user) {
        Permissions permission = new Permissions(user, PermissionLevel.EDIT);
        permission.setGroup(this);
        permissions.add(permission);
    }
 // Method to add a user with view access
    public void addUserWithViewAccess(User user) {
        Permissions permission = new Permissions(user, PermissionLevel.VIEW);
        permission.setGroup(this);
        permissions.add(permission);
    }
    public void addUser(User user) {
        Permissions permission = new Permissions(user, PermissionLevel.VIEW); // Default permission level is VIEW
        permission.setGroup(this);
        permissions.add(permission);
    }

}
