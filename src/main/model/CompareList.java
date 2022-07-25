package model;

import java.util.ArrayList;
import java.util.List;

public class CompareList {
    private List<Player> compareList;

    // EFFECTS: instantiates a new compareList object
    public CompareList() {
        compareList = new ArrayList<>();

    }

    // EFFECTS: adds a player to the given compareList object
    public boolean addPlayer(Player player) {

        compareList.add(player);

        return true;

    }

    public List<Player> getCompareList() {
        return compareList;
    }
}
