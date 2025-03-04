package pl.puzzle.impact.user;

import org.springframework.stereotype.Service;
import pl.puzzle.impact.common.exception.UserNotFoundException;
import pl.puzzle.impact.token.TokenService;
import pl.puzzle.impact.user.dto.UserCreateDto;

import static pl.puzzle.impact.token.TokenType.ACTIVATION;

@Service
public class CreateUserService {
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final TokenService tokenService;

    public CreateUserService(ProfileRepository profileRepository, UserRepository userRepository, RoleRepository roleRepository, TokenService tokenService) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.tokenService = tokenService;
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

    public User activateUser(String token) {
        var userId = tokenService.validateAndGetUserId(token, ACTIVATION);

        return userRepository.findById(userId)
                .map(user -> {
                    user.activateAccount();
                    return userRepository.save(user);
                })
                .orElseThrow(UserNotFoundException::new);
    }
}
