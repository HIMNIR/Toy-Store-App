/**

The Puzzles class represents a type of toy that is a puzzle.
It extends the Toy class and adds a String variable to store the type of puzzle.
*/
package model;

import java.math.BigInteger;

public class Puzzles extends Toy {
	private String type;

	/**
	 * Constructs a Puzzles object with the given values.
	 *
	 * @param sin the serial number of the puzzle
	 * @param item the name of the puzzle
	 * @param brand the brand of the puzzle
	 * @param price the price of the puzzle
	 * @param stock the stock count of the puzzle
	 * @param age the age restriction of the puzzle
	 * @param type the type of the puzzle
	 */
	public Puzzles(String sin, String item, String brand, double price, int stock, int age, String type) {
		super(sin, item, brand, price, stock, age);
		this.type = type;
	}

	/**
	 * Gets the type of puzzle.
	 *
	 * @return the type of the puzzle as a String
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type of puzzle.
	 *
	 * @param type the type of puzzle to be set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Returns a String representation of the Puzzles object.
	 *
	 * @return a string that includes the category, serial number, name, brand, price, stock count, age restriction, and type of the puzzle
	 */
	@Override
	public String toString() {
		return "Category: Puzzle," + " Serial Number:" + getS_N()+ "," + " Name:" + getName()+"," + " Brand:" + getBrand()+"," + 
				" Cost:" + getPrice()+"," + " Stock:" + getCount()+"," + " Appropriate Age:" + getAge()+"," + " Puzzle Type:" + getType();
	}

	/**
	 * Returns a formatted String representation of the Puzzles object.
	 *
	 * @return a formatted string that includes the serial number, name, brand, price, stock count, age restriction, and type of the puzzle
	 */
	public String format() {
		 return getS_N() + ";" + getName() + ";" + getBrand() + ";" + getPrice() + ";"  + getCount() + ";" + getAge() + ";" + getType(); 
	 }
}


