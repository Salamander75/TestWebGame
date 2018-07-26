package com.game.webgame.authentication;


import com.game.webgame.authentication.model.Player;
import com.game.webgame.authentication.service.PlayerService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    private String registrationSuccess = "Registration successful";
    private String registrationFailed = "Something went wrong. Try again later";

    @Autowired
    private PlayerService playerService;

    @RequestMapping(value = "/user/create", method = RequestMethod.POST, consumes = "application/json")
    public String addNewPlayer(@RequestBody Player player) {
        player = playerService.findUserByEmail(player.getEmail());

        if (player != null) {

        }
        return registrationSuccess;
    }
}
