package com.game.webgame.registration;


import com.game.webgame.registration.model.Player;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    private String registrationSuccess = "Registration successful";
    private String registrationFailed = "Something went wrong. Try again later";

    @RequestMapping(value = "/user/create", method = RequestMethod.POST, consumes = "application/json")
    public String addNewUser(@RequestBody String s) {
        System.out.println(s);
        return registrationSuccess;
    }
}
