package pl.puzzle.impact.user;

import org.springframework.stereotype.Service;
import pl.puzzle.impact.user.dto.UserCreateDTO;

@Service
public class CreateUserService {
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public CreateUserService(ProfileRepository profileRepository, UserRepository userRepository, RoleRepository roleRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User createUser(UserCreateDTO userCreateDTO) {

        User user = User.createUser(userCreateDTO);
        userRepository.save(user);
        Profile profile = Profile.createProfile(userCreateDTO, user.getId());
        profileRepository.save(profile);
        Role role = Role.createRole(user.getId());
        roleRepository.save(role);
        return user;
    }
}
