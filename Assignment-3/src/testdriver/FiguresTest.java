package testdriver;
import static org.junit.Assert.*;

import org.junit.Test;

import model.Figures;

public class FiguresTest {

	@Test
	public void testGetType() {
		Figures figure = new Figures("123", "Test Figure", "Test Brand", 9.99, 10, 3, "Test Type");
		assertEquals("Test Type", figure.getType());
	}

	@Test
	public void testSetType() {
		Figures figure = new Figures("123", "Test Figure", "Test Brand", 9.99, 10, 3, "Test Type");
		figure.setType("New Type");
		assertEquals("New Type", figure.getType());
	}

	@Test
	public void testToString() {
		Figures figure = new Figures("123", "Test Figure", "Test Brand", 9.99, 10, 3, "Test Type");
		assertEquals("Category: Figure, Serial Number:123, Name:Test Figure, Brand:Test Brand, Cost:9.99, Stock:10, Appropriate Age:3, Classification:Test Type", figure.toString());
	}

	@Test
	public void testFormat() {
		Figures figure = new Figures("123", "Test Figure", "Test Brand", 9.99, 10, 3, "Test Type");
		assertEquals("123;Test Figure;Test Brand;9.99;10;3;Test Type", figure.format());
	}

}
