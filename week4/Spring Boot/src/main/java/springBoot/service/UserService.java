package springBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springBoot.entity.User;
import springBoot.repository.UserRepository;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public boolean updateUserPassword(String newPassword, String token, Map<Integer, String> tokensMap) {

        Integer userId = getUserId(tokensMap, token);

        if (userId == null) return false;

        if (userRepository.updatePassword(userId, newPassword)) return true;

        return false;
    }

    private Integer getUserId(Map<Integer, String> tokensMap, String sendToken) {
        for (int id : tokensMap.keySet())
            if (tokensMap.get(id).equals(sendToken))
                return id;

        return null;
    }


    public boolean deleteUser(String token, Map<Integer, String> tokensMap) {
        Integer userId = getUserId(tokensMap, token);

        if (userId == null) return false;

        if (userRepository.deleteUser(userId)) return true;

        return false;
    }

    public boolean updateUserEmail(String newEmail, String token, Map<Integer, String> tokensMap) {

        Integer userId = getUserId(tokensMap, token);

        if (userId == null) return false;

        if (userRepository.updateEmail(userId, newEmail)) return true;

        return false;
    }

}
