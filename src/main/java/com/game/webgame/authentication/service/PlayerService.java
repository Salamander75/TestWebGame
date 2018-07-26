package com.game.webgame.authentication.service;

import com.game.webgame.authentication.model.Player;


public interface PlayerService {
    public Player findUserByEmail(String email);

    public void saveUser(Player player);
}

