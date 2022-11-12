package springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springBoot.entity.User;
import springBoot.service.AuthenticationService;
import springBoot.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "change/password", method = RequestMethod.PUT)
    public ResponseEntity<String> changePassword(@RequestBody User body, @RequestHeader("token") String token) {

        if (!userService.updateUserPassword(body.getPassword(), token, authenticationService.getTokens()))
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("can't change password !");

        return ResponseEntity.ok("Password changed successfully");
    }


    @RequestMapping(value = "change/email", method = RequestMethod.PUT)
    public ResponseEntity<String> changeEmail(@RequestBody User body, @RequestHeader("token") String token) {

        if (!userService.updateUserEmail(body.getEmail(), token, authenticationService.getTokens()))
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("can't change email !");

        return ResponseEntity.ok("email changed successfully");
    }


    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@RequestHeader("token") String token) {

        if (!userService.deleteUser(token, authenticationService.getTokens()))
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("can't delete the user !");

        return ResponseEntity.ok("User deleted");
    }

}
