package persistence;

import org.json.JSONObject;

// modeled after JsonSerializationDemo.persistence.Writable (as provided for this project)
public interface Writable {
        // EFFECTS: returns this as JSON object
    JSONObject toJson();

}
