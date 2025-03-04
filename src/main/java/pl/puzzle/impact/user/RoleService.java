package pl.puzzle.impact.user;

import org.springframework.stereotype.Service;
import pl.puzzle.impact.common.exceptions.UserNotFoundException;
import pl.puzzle.impact.user.dto.RoleCreateDto;
import pl.puzzle.impact.user.dto.RoleUpdateDto;

import java.util.List;
import java.util.UUID;

@Service
public class RoleService {
private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getRolesByUser(UUID userId) {
        List<Role> allRoles = roleRepository.findAll();
        return allRoles.stream()
                .filter(role -> role.getUserId().equals(userId))
                .toList();
    }

    public Role createRole(RoleCreateDto roleCreateDto, UUID userId) {
        Role role = Role.createRole(roleCreateDto, userId);
        return roleRepository.save(role);
    }

    public Role updateRole(UUID id, RoleUpdateDto roleUpdateDto) {
        Role role = roleRepository.findById(id).orElseThrow(UserNotFoundException::new);
        role.updateRole(roleUpdateDto);
        roleRepository.save(role);
        return role;
    }
}
