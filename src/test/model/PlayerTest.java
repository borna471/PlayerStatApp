package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// tests the Player class
class PlayerTest {
    private Player player1;
    private Player player2;

    @BeforeEach
    void setup() {

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

    }

    @Test
    void testPlayerMaker() {

        assertEquals(player1.getName(), "Messi");
        assertEquals(player2.getName(), "Ronaldo");
        assertEquals(player1.getPost(), "winger");
        assertEquals(player2.getPost(), "striker");

    }



}