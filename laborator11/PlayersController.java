package com.example.laborator11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayersController {
    private final List<Player> players = new ArrayList<>();
    public PlayersController() {

        players.add(new Player(1, "Jucator1"));
        players.add(new Player(2, "Jucator2"));
    }
    @GetMapping("/all")
    public List<Player> getPlayers() {
        return players;
    }
    @GetMapping("/count")
    public int countPlayers() {
        return players.size();
    }

    @GetMapping("/{id}")
    public Player getProduct(@PathVariable("id") int id) {
        return players.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}