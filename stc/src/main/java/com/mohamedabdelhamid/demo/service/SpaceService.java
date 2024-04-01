package com.mohamedabdelhamid.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mohamedabdelhamid.demo.domains.PermissionGroup;
import com.mohamedabdelhamid.demo.domains.Space;
import com.mohamedabdelhamid.demo.domains.User;
import com.mohamedabdelhamid.demo.dto.UserDto;
import com.mohamedabdelhamid.demo.repository.PermissionGroupRepository;
import com.mohamedabdelhamid.demo.repository.SpaceRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SpaceService {
    
    private final PermissionGroupRepository permissionGroupRepository;
    private final SpaceRepository spaceRepository;

    public SpaceService(PermissionGroupRepository permissionGroupRepository, SpaceRepository spaceRepository) {
        this.permissionGroupRepository = permissionGroupRepository;
        this.spaceRepository = spaceRepository;
    }

    public Space createSpace(String spaceName, String groupName, List<UserDto> users) {
        // Create permission group
        PermissionGroup permissionGroup = new PermissionGroup();
        permissionGroup.setGroupName(groupName);
        
        for (UserDto userDto : users) {
            User user = new User();
            user.setEmail(userDto.getEmail());
            user.setAccessLevel(userDto.getAccessLevel());
            user.setPermissionGroup(permissionGroup);
            // Add user to the permission group
            permissionGroup.addUser(user);
        }
        
        permissionGroup = permissionGroupRepository.save(permissionGroup);
        
        // Create space
        Space space = new Space();
        space.setName(spaceName);
        space.setPermissionGroup(permissionGroup);
        
        return spaceRepository.save(space);
    }

}
