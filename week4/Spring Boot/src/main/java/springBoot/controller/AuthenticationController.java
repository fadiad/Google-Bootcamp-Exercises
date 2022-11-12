package springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springBoot.entity.Response;
import springBoot.entity.User;
import springBoot.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody User user) {

        String token = authenticationService.login(user);

        if (token == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("email or password is not correct !");

        return ResponseEntity.ok(token);
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public ResponseEntity<String> signup(@RequestBody User user) {

        Response response = authenticationService.addUser(user);

        return ResponseEntity
                .status(response.getStatus())
                .body(response.getMessage());
    }


    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public ResponseEntity<String> logout(@RequestHeader("token") String token) {

        if (!authenticationService.logout(token))
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("some error !");

        return ResponseEntity.ok("logout done successfully");
    }

}
