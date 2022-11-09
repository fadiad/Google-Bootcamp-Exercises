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
        for (int i = 0; i < 30; i++) {
            users.add(User.generatRandonUser());
        }
    }

    public List<User> findAll() {
        return users;
    }


}
