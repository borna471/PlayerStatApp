package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// a list of Players that will be used for the comparison feature of the program
public class CompareList implements Writable {
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

    // modeled after JsonSerializationDemo.model.WorkRoom (as provided for this project)
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        // json.put("name", name);
        json.put("players", playersToJson());
        return json;
    }

    // EFFECTS: returns players in this compareList as a JSON array
    // modeled after JsonSerializationDemo.model.WorkRoom (as provided for this project)
    private JSONArray playersToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Player p : compareList) {
            jsonArray.put(p.toJson());
        }

        return jsonArray;
    }

    public List<Player> getCompareList() {
        return compareList;
    }


}
