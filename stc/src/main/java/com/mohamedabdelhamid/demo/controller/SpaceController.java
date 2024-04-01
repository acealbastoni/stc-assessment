package com.mohamedabdelhamid.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohamedabdelhamid.demo.domains.Space;
import com.mohamedabdelhamid.demo.dto.UserDto;
import com.mohamedabdelhamid.demo.enums.AccessLevel;
import com.mohamedabdelhamid.demo.service.SpaceService;

@RestController
@RequestMapping("/api/spaces")
public class SpaceController {

    private final SpaceService spaceService;

    public SpaceController(SpaceService spaceService) {
        this.spaceService = spaceService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createSpaceAndAssignPermissions() {
        // Create the space
        Space space = spaceService.createSpace("stc-assessments", "admin", List.of(
                new UserDto("user1@example.com", AccessLevel.VIEW),
                new UserDto("user2@example.com", AccessLevel.EDIT)
        ));

        return ResponseEntity.ok("Space 'stc-assessments' created and permissions assigned successfully.");
    }
}
