package pl.puzzle.impact.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.puzzle.impact.user.dto.UserCreateDTO;
import pl.puzzle.impact.user.dto.UserUpdateDTO;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(UserCreateDTO userCreateDTO) {
        User user = new User();
        user.setActive(userCreateDTO.isActive());
        return userRepository.save(user);
    }

    public User updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        return userRepository.findById(id).map(user -> {
            user.setActive(userUpdateDTO.isActive());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
