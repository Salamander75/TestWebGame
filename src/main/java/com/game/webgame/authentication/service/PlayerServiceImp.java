package com.game.webgame.authentication.service;

import com.game.webgame.authentication.model.Player;
import com.game.webgame.authentication.model.Role;
import com.game.webgame.authentication.repository.RoleRepository;
import com.game.webgame.authentication.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
public class PlayerServiceImp implements PlayerService {

    @Autowired
    private PlayerRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Player findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(Player player) {
        player.setEncryptedPassword(bCryptPasswordEncoder.encode(player.getEncryptedPassword()));
        player.setActive(true);
        Role userRole = roleRepository.findByRole("PLAYER");
        player.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(player);

    }
}
