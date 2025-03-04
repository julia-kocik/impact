package pl.puzzle.impact.user;

import org.springframework.stereotype.Service;
import pl.puzzle.impact.common.exceptions.EmailNotFoundException;
import pl.puzzle.impact.common.exceptions.InvalidTokenException;
import pl.puzzle.impact.common.exceptions.UserNotFoundException;
import pl.puzzle.impact.user.dto.SendTokenDto;
import pl.puzzle.impact.user.dto.UserCreateDto;

import java.util.UUID;

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

    public Token sendToken(SendTokenDto sendTokenDto) {
        Profile profile = profileRepository.findByEmail(sendTokenDto.email()).orElseThrow(EmailNotFoundException::new);
        return tokenService.sendToken(profile.getId(), sendTokenDto.type());
    }

    public User activateUser(String token, UUID userId) {
        if(!tokenService.validateToken(token)) {
            throw new InvalidTokenException();
        }

        return userRepository.findById(userId)
                .map(user -> {
                    user.activateAccount();
                    return userRepository.save(user);
                })
                .orElseThrow(UserNotFoundException::new);
    }

}
