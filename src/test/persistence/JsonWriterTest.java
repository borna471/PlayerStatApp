package persistence;

import model.CompareList;
import model.Player;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.ComponentInputMapUIResource;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// tests the JsonWriter class

public class JsonWriterTest extends JsonTest {

    Player player1;
    Player player2;




    @Test
    void testWriterInvalidFile() {
        try {
            CompareList cl = new CompareList();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }


    @Test
    void testWriterEmptyCompareList() {
        try {
            CompareList cl = new CompareList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyCompareList.json");
            writer.open();
            writer.write(cl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyCompareList.json");
            cl = reader.read();
            assertEquals(0, cl.getCompareList().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralCompareList() {

        player1 = new Player("Messi", "att", "winger",
                11, 14, 34, 9,
                115, 39, 0, 76, 87,
                0.32, 0.74, 0.68, 2.56);

        player2 = new Player("Ronaldo", "att", "striker",
                24, 3, 39, 21,
                133, 55, 0, 36, 30,
                0.62, 0.69, 0.62, 0.77);

        try {
            CompareList cl = new CompareList();
            cl.addPlayer(player1);
            cl.addPlayer(player2);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralCompareList.json");
            writer.open();
            writer.write(cl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralCompareList.json");
            cl = reader.read();
            List<Player> players = cl.getCompareList();
            assertEquals(2, players.size());
            checkPlayer(players.get(0), "Messi", "att", "winger", 11, 14, 34);
            checkPlayer(players.get(1), "Ronaldo", "att", "striker", 24, 3, 39);

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
