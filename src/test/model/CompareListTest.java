package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompareListTest {
    private List<Player> list1;
    private List<Player> list2;
    private List<Player> list3;
    private Player player1;
    private Player player2;
    private CompareList cmprList;

    @BeforeEach
    void setup() {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        cmprList = new CompareList();
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
        list2.add(player1);
        list3.add(player1);
        list3.add(player2);




    }

    @Test
    void testMaker() {
        assertEquals(list1.size(), 0);
        assertEquals(list2.size(), 1);
        assertEquals(list3.size(), 2);
        assertNotNull(list2);
        assertNotNull(list3);
        assertEquals(list2.get(0).getName(), "Messi");
        assertEquals(list3.get(1).getName(), "Ronaldo");

    }

//
    @Test
    void testAddPlayer() {
        cmprList.addPlayer(player1);
        assertEquals(cmprList.getCompareList().size(), 1);
        assertTrue(cmprList.addPlayer(player2));
        cmprList.addPlayer(player2);
        assertEquals(cmprList.getCompareList().get(1), player2);
        assertEquals(cmprList.getCompareList().get(0), player1);

    }


}