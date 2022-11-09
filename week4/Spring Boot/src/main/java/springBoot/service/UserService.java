package springBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springBoot.entity.User;
import springBoot.repository.UserRepository;

import java.util.List;

@Repository
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
