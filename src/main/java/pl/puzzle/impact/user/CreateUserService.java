package pl.puzzle.impact.user;

import org.springframework.stereotype.Service;
import pl.puzzle.impact.user.dto.UserCreateDto;

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

    public User createUser(UserCreateDto userCreateDto) {

        User user = User.createUser(userCreateDto);
        userRepository.save(user);
        Profile profile = Profile.createProfile(userCreateDto, user.getId());
        profileRepository.save(profile);
        Role role = Role.createRole(user.getId());
        roleRepository.save(role);
        return user;
    }
}
