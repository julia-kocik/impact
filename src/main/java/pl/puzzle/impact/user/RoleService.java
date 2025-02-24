package pl.puzzle.impact.user;

import org.springframework.stereotype.Service;
import pl.puzzle.impact.user.dto.RoleCreateDTO;
import pl.puzzle.impact.user.dto.RoleUpdateDTO;

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

    public Role createRole(RoleCreateDTO roleCreateDTO, UUID userId) {
        Role role = Role.createRole(roleCreateDTO, userId);
        return roleRepository.save(role);
    }

    public Role updateRole(UUID id, RoleUpdateDTO roleUpdateDTO) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        role.updateRole(roleUpdateDTO);
        roleRepository.save(role);
        return role;
    }
}
