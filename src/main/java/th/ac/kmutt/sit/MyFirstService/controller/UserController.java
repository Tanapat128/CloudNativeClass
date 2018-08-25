package th.ac.kmutt.sit.MyFirstService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    User allUser[] = { new User(1, "Adam"), new User(2, "Bobby"), new User(3, "Cara"), new User(4, "Danny"),
            new User(5, "Emily") };

    @GetMapping("/user/1")
    public User getUser1() {
        return allUser[0];
    }

    @GetMapping("/user/2")
    public User getUser2() {
        return allUser[1];
    }

    @GetMapping("/user/3")
    public User getUser3() {
        return allUser[2];
    }

    @GetMapping("/user/4")
    public User getUser4() {
        return allUser[3];
    }

    @GetMapping("/user/5")
    public User getUser5() {
        return allUser[4];
    }

    @GetMapping("/users")
    public User[] getAllUser() {

        return allUser;
    }
}
