package persistence;

import model.CompareList;
import model.Player;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import org.json.*;


// Represents a reader that reads compareList from JSON data stored in file
public class JsonReader {
    private String source;
    private Integer placeholder;


    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads compareList from file and returns it;
    // throws IOException if an error occurs reading data from file
    public CompareList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseCompareList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    private CompareList parseCompareList(JSONObject jsonObject) {

        CompareList cl = new CompareList();
        addPlayers(cl, jsonObject);
        return cl;


    }


    // MODIFIES: cl
    // EFFECTS: parses playerList from JSON object and adds them to CompareList
    private void addPlayers(CompareList cl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("players");
        for (Object json : jsonArray) {
            JSONObject nextPlayer = (JSONObject) json;
            addPlayer(cl, nextPlayer);
        }
    }

    // MODIFIES: cl
    // EFFECTS: parses Player from JSON object and adds it to CompareList
    private void addPlayer(CompareList cl, JSONObject jsonObject) {
        placeholder = 0;
        String name = jsonObject.getString("name");
        String category = jsonObject.getString("category");
        String position = jsonObject.getString("position");
        Integer goals = jsonObject.getInt("goals");
        Integer assists = jsonObject.getInt("assists");
        Integer matches = jsonObject.getInt("matches");
        Player player = new Player(name, category, position, goals, assists, matches,
                0, 0, 0, 0, 0, 0, 0.00,
                0.00, 0.00, 0.00);
        cl.addPlayer(player);
    }

}
