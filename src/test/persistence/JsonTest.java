package persistence;


import model.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkPlayer(Player player,
                               String name,
                               String category,
                               String position,
                               Integer goals,
                               Integer assists,
                               Integer matches) {
        assertEquals(name, player.getName());
        assertEquals(category, player.getCat());
        assertEquals(position, player.getPost());
        assertEquals(goals, player.getGs());
        assertEquals(assists, player.getAst());
        assertEquals(matches, player.getMts());
    }


}
