package testdriver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Puzzles;

public class PuzzlesTest {
    @Test
    public void testGetType() {
        Puzzles puzzle = new Puzzles("1234", "Castle Puzzle", "Ravensburger", 19.99, 10, 6, "Jigsaw");
        Assertions.assertEquals("Jigsaw", puzzle.getType());
    }

    @Test
    public void testSetType() {
        Puzzles puzzle = new Puzzles("1234", "Castle Puzzle", "Ravensburger", 19.99, 10, 6, "Jigsaw");
        puzzle.setType("3D Puzzle");
        Assertions.assertEquals("3D Puzzle", puzzle.getType());
    }

    @Test
    public void testToString() {
        Puzzles puzzle = new Puzzles("1234", "Castle Puzzle", "Ravensburger", 19.99, 10, 6, "Jigsaw");
        String expected = "Category: Figure, Serial Number:0123456789, Name:Castle Puzzle, Brand:Ravensburger, Cost:19.99, Stock:10, Appropriate Age:6, Puzzle Type:Jigsaw";
        Assertions.assertEquals(expected, puzzle.toString());
    }

    @Test
    public void testFormat() {
        Puzzles puzzle = new Puzzles("1234", "Castle Puzzle", "Ravensburger", 19.99, 10, 6, "Jigsaw");
        String expected = "1234;Castle Puzzle;Ravensburger;19.99;10;6;Jigsaw";
        Assertions.assertEquals(expected, puzzle.format());
    }
}