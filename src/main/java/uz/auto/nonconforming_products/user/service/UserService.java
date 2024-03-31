package uz.auto.nonconforming_products.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.auto.nonconforming_products.user.entity.User;
import uz.auto.nonconforming_products.user.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
