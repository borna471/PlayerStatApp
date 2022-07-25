package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerListTest {

    private PlayerList plrList1;
    private PlayerList plrList2;
    private PlayerList plrList3;
    private PlayerList plrList4;
    private Player player1;
    private Player player2;

    @BeforeEach
    void setup() {
        plrList1 = new PlayerList();
        plrList2 = new PlayerList();
        plrList3 = new PlayerList();
        plrList4 = new PlayerList();
        player1 = new Player(
                "Messi",
                "att",
                "winger",
                11,
                14,
                34,
                9,
                115,
                39,
                0,
                76,
                87,
                0.32,
                0.74,
                0.68,
                2.56
        );
        player2 = new Player(
                "Ronaldo",
                "att",
                "striker",
                24,
                3,
                39,
                21,
                133,
                55,
                0,
                36,
                30,
                0.62,
                0.69,
                0.62,
                0.77
        );
        plrList2.getPlayerList().add(player1);
        plrList3.getPlayerList().add(player1);
        plrList3.getPlayerList().add(player2);
        plrList4.getPlayerList().add(player2);
    }


    @Test
    void testMaker() {
        assertEquals(plrList1.getPlayerList().size(), 0);
        assertEquals(plrList2.getPlayerList().size(), 1);
        assertEquals(plrList3.getPlayerList().size(), 2);
        assertNotNull(plrList2);
        assertNotNull(plrList3);
        assertEquals(plrList2.getPlayerList().get(0).getName(), "Messi");
        assertEquals(plrList3.getPlayerList().get(1).getName(), "Ronaldo");
    }


    @Test
    void testFilterByPost() {
        assertEquals(plrList3.filterByPost("winger"), plrList2.getPlayerList());
        assertEquals(plrList3.filterByPost("winger").size(), 1);
        assertEquals(plrList3.filterByPost("striker"), plrList4.getPlayerList());
        assertEquals(plrList3.filterByPost("striker").size(), 1);
        assertEquals(plrList3.filterByPost("centre-forward").size(), 0);
        assertEquals(plrList2.filterByPost("winger"), plrList2.getPlayerList());
        assertEquals(plrList2.filterByPost("winger").size(), 1);
        assertEquals(plrList2.filterByPost("striker"), plrList1.getPlayerList());
        assertEquals(plrList2.filterByPost("striker").size(), 0);
        // assertNull(plrList1.filterByPost("striker"));



    }

//
    @Test
    void testShowRelStats() {

        assertEquals(plrList1.showRelStats().size(), 0);
        assertEquals(plrList2.showRelStats().get(0).getGs(), 14);

    }

}