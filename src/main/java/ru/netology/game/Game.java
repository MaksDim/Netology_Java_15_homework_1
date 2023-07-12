package ru.netology.game;

import ru.netology.domain.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();

    public void register(Player player) {
        this.players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        var first = findPlayer(playerName1);
        var second = findPlayer(playerName2);
        if (first == null || second == null) {
            throw new RuntimeException("One or both players not registered");
        }
        var result = first.getStrength() - second.getStrength();
        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return 2;
        }
        return 0;
    }

    private Player findPlayer(String name) {
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null;
    }

 }
