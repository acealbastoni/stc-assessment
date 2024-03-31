package com.mohamedabdelhamid.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohamedabdelhamid.demo.domains.PermissionGroup;
import com.mohamedabdelhamid.demo.domains.Space;
import com.mohamedabdelhamid.demo.domains.User;
import com.mohamedabdelhamid.demo.dto.UserDto;
import com.mohamedabdelhamid.demo.repository.PermissionGroupRepository;
import com.mohamedabdelhamid.demo.repository.SpaceRepository;
import com.mohamedabdelhamid.demo.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class SpaceService {
 @Autowired
 private SpaceRepository spaceRepository;
 
 @Autowired
 private PermissionGroupRepository permissionGroupRepository;
 
 @Transactional
 public Space createSpace(String spaceName, String groupName, List<UserDto> users) {
     // Create permission group
     PermissionGroup permissionGroup = new PermissionGroup();
     permissionGroup.setName(groupName);
     
     for (UserDto userDto : users) {
         User user = new User();
         user.setEmail(userDto.getEmail());
         user.setAccessLevel(userDto.getAccessLevel());
         user.setPermissionGroup(permissionGroup);
         permissionGroup.getUsers().add(user);
     }
     
     permissionGroup = permissionGroupRepository.save(permissionGroup);
     
     // Create space
     Space space = new Space();
     space.setName(spaceName);
     space.setPermissionGroup(permissionGroup);
     
     return spaceRepository.save(space);
 }
 

 @Autowired
 private UserRepository userRepository;

 public Space createSpace(String spaceName) {
     // Create the space
     Space space = new Space();
     space.setName(spaceName);
     return spaceRepository.save(space);
 }

 public PermissionGroup assignAdminGroup(Space space) {
     // Create admin permission group and assign it to the space
     PermissionGroup adminGroup = new PermissionGroup();
     adminGroup.setGroupName("admin");
     adminGroup.setSpace(space);
     return permissionGroupRepository.save(adminGroup);
 }

 public void addUserWithViewAccess(PermissionGroup group, String userEmail) {
     // Add user to the permission group with VIEW access
     User user = userRepository.findByEmail(userEmail);
     if (user != null) {
         group.addUserWithViewAccess(user);
         permissionGroupRepository.save(group);
     }
 }

 public void addUserWithEditAccess(PermissionGroup group, String userEmail) {
     // Add user to the permission group with EDIT access
     User user = userRepository.findByEmail(userEmail);
     if (user != null) {
         group.addUserWithEditAccess(user);
         permissionGroupRepository.save(group);
     }
 }

 
 
 
}
