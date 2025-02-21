package pl.puzzle.impact.user;

import org.springframework.stereotype.Service;
import pl.puzzle.impact.user.dto.ActivateUserDTO;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, ActivateUserDTO userUpdateDTO) {
        return userRepository.findById(id).map(user -> {
            user.setActive(userUpdateDTO.isActive());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
