package springBoot.repository;

import org.springframework.stereotype.Repository;
import springBoot.entity.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
    }

    public boolean updatePassword(int userId, String newPassword) {
        for (User user : users)
            if (user.getId() == userId) {
                user.setPassword(newPassword);
                return true;
            }
        return false;
    }

    public List<User> findAll() {
        return users;
    }

    public boolean deleteUser(int userId) {

        for (User user : users)
            if (user.getId() == userId) {
                users.remove(user);
                return true;
            }

        return false;
    }

    public User addUser(User user) {
        if (isUserExisted(user.getEmail()))
            return null;

        User newUser = new User(user.getEmail(), user.getPassword());
        users.add(newUser);
        return newUser;
    }

    private boolean isUserExisted(String email) {
        return users.stream().anyMatch(user -> user.getEmail().equals(email));
    }

    public boolean isUserExistAndPasswordIsFit(User user) {
        for (User userOfUsersList : users) {
            if (userOfUsersList.getEmail().equals(user.getEmail()))
                if (userOfUsersList.getPassword().equals(user.getPassword())) {
                    return true;
                }
        }
        return false;
    }


    public User getUserId(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findAny()
                .orElse(null);
    }


    public boolean updateEmail(Integer userId, String newEmail) {
        for (User user : users)
            if (user.getId() == userId) {
                user.setEmail(newEmail);
                return true;
            }

        return false;
    }
}
