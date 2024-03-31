package com.mohamedabdelhamid.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohamedabdelhamid.demo.domains.PermissionGroup;
import com.mohamedabdelhamid.demo.domains.Space;
import com.mohamedabdelhamid.demo.service.SpaceService;

import org.springframework.stereotype.Service;

@RestController
@RequestMapping("/api/spaces")
public class SpaceController {

    private final SpaceService spaceService;

    public SpaceController(SpaceService spaceService) {
        this.spaceService = spaceService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createSpaceAndAssignPermissions() {
        // Create the space
        Space space = spaceService.createSpace("stc-assessments");

        // Assign permission group with VIEW and EDIT access
        PermissionGroup adminGroup = spaceService.assignAdminGroup(space);

        // Add users to the permission group with appropriate access
        spaceService.addUserWithViewAccess(adminGroup, "user1@example.com");
        spaceService.addUserWithEditAccess(adminGroup, "user2@example.com");

        return ResponseEntity.ok("Space 'stc-assessments' created and permissions assigned successfully.");
    }
}
