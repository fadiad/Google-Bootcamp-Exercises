package springBoot.service;

import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springBoot.entity.Response;
import springBoot.entity.User;
import springBoot.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    private Map<Integer, String> tokens;

    public AuthenticationService() {
        tokens = new HashMap<>();
    }

    private boolean isUserValid(User user) {
        return userRepository.isUserExistAndPasswordIsFit(user);
    }

    public String login(User user) {

        if (isUserValid(user)) {
            int userId = userRepository.getUserId(user.getEmail()).getId();
            String token = generateRandomToken();
            tokens.put(userId, token);
            return token;
        }
        return null;
    }

    public Response addUser(User user) {

        if (!isEmailValid(user.getEmail()))
            return new Response(400, "Invalid email !");

        if (!isPasswordValid(user.getPassword()))
            return new Response(400, "Invalid user password , password should be more than 8 characters !");

        if (userRepository.addUser(user) == null)
            return new Response(400, "User is already existed !");


        return new Response(200, "User is registered successfully");
    }

    private boolean isEmailValid(String emailAddress) {
        EmailValidator emailValidator = new EmailValidator();
        return emailValidator.isValid(emailAddress, null);
    }


    private boolean isPasswordValid(String password) {
        return password.length() >= 8;
    }


    private String generateRandomToken() {
        int token = ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE);
        return String.valueOf(token);
    }

    public Map<Integer, String> getTokens() {
        return tokens;
    }

    public boolean logout(String token) {
        for (int id : tokens.keySet())
            if (tokens.get(id).equals(token)) {
                tokens.remove(id);
                return true;
            }

        return false;
    }

}
