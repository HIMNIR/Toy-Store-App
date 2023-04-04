package testdriver;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Board_Games;

public class BoardGamesTest {

    @Test
    public void testBoard_Games() {
        Board_Games game = new Board_Games("1234", "Monopoly", "Hasbro", 20.0, 10, 8, 2, 6, "Parker Brothers");
        
        assertEquals("1234", game.getS_N());
        assertEquals("Monopoly", game.getName());
        assertEquals("Hasbro", game.getBrand());
        assertEquals(20.0, game.getPrice(), 0.01);
        assertEquals(10, game.getCount());
        assertEquals(8, game.getAge());
        assertEquals("2-6", game.getRange());
        assertEquals("Parker Brothers", game.getDevelopers());
    }
    
    @Test
    public void testSetRange() {
        Board_Games game = new Board_Games("1234", "Monopoly", "Hasbro", 20.0, 10, 8, 2, 6, "Parker Brothers");
        
        game.setRange(3, 5);
        assertEquals("3-5", game.getRange());
    }
    
    @Test
    public void testFormat() {
        Board_Games game = new Board_Games("1234", "Monopoly", "Hasbro", 20.0, 10, 8, 2, 6, "Parker Brothers");
        
        String expected = "1234;Monopoly;Hasbro;20.0;10;8;2-6;Parker Brothers";
        assertEquals(expected, game.format());
    }
}
