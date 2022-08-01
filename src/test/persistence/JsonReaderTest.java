package persistence;

import model.CompareList;
import model.Player;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// tests the JsonReader class
public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            CompareList cl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyCompareList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyCompareList.json");
        try {
            CompareList cl = reader.read();
            assertEquals(0, cl.getCompareList().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }


    @Test
    void testReaderGeneralCompareList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralCompareList.json");
        try {
            CompareList cl = reader.read();
            List<Player> players = cl.getCompareList();
            assertEquals(2, players.size());
            checkPlayer(players.get(0), "Messi", "att", "winger", 11, 14, 34);
            checkPlayer(players.get(1), "Ronaldo", "att", "striker", 24, 3, 39);
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
