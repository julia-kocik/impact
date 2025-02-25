package pl.puzzle.impact.user.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.puzzle.impact.user.Role;
import pl.puzzle.impact.user.RoleService;
import pl.puzzle.impact.user.dto.RoleCreateDto;
import pl.puzzle.impact.user.dto.RoleUpdateDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/role")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Role>> getRolesByUser(@PathVariable UUID userId) {
        List<Role> roles = roleService.getRolesByUser(userId);
        return ResponseEntity.ok(roles);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Role> createRole(@RequestBody RoleCreateDto roleCreateDto, @PathVariable UUID userId) {
        return ResponseEntity.ok(roleService.createRole(roleCreateDto, userId));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable UUID id, @RequestBody RoleUpdateDto roleUpdateDto) {
        try {
            Role updatedRole = roleService.updateRole(id, roleUpdateDto);
            return ResponseEntity.ok(updatedRole);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
