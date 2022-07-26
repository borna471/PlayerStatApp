package model;

import java.util.ArrayList;
import java.util.List;

// a list of Players that will be used for the comparison feature of the program
public class CompareList {
    private List<Player> compareList;

    // EFFECTS: instantiates a new compareList object
    public CompareList() {
        compareList = new ArrayList<>();

    }

    // EFFECTS: adds a player to the given compareList object, and returns true
    public boolean addPlayer(Player player) {

        compareList.add(player);

        return true;

    }

    public List<Player> getCompareList() {
        return compareList;
    }
}
