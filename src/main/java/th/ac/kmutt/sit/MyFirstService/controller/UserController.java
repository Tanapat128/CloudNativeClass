package th.ac.kmutt.sit.MyFirstService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    User allUser[] = { new User(1, "Adam"), new User(2, "Bobby"), new User(3, "Cara"), new User(4, "Danny"),
            new User(5, "Emily") };

    @GetMapping("/users/{userID}")
    public User getUser(@PathVariable String userID) {
        int id = Integer.parseInt(userID) - 1;
        try {
            return allUser[id];
        } catch (Exception ex) {
            return null;
        }
    }

    @GetMapping("/users")
    public User[] getAllUser() {

        return allUser;
    }
}
