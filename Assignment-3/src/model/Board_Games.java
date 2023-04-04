package model;

/**
 * The {@code Board_Games} class represents a board game toy. It extends the {@code Toy} class.
 */
public class Board_Games extends Toy {

	// instance variables
	private String Range;// maximum number of players
	private String developers; // developers of the game
	private int Min;
	private int Max;
	
	/**
	 * Constructs a new {@code Board_Games} object with the specified attributes.
	 * @param sin the serial number of the toy
	 * @param item the name of the toy
	 * @param brand the brand of the toy
	 * @param price the price of the toy
	 * @param stock the stock of the toy
	 * @param age the recommended age for the toy
	 * @param Min the minimum number of players for the board game
	 * @param Max the maximum number of players for the board game
	 * @param developers the developers of the board game
	 */
	public Board_Games(String sin, String item, String brand, double price, int stock, int age, int Min, int Max, String developers) {
		super(sin, item, brand, price, stock, age);
		this.Min = Min;
		this.Max = Max;
		this.developers = developers;
		setRange(Min, Max);
	}

	// getters and setters
	
	/**
	 * Sets the minimum number of players for the board game.
	 * @param Min the minimum number of players
	 */
	public void setMin(int Min) {
		this.Min = Min;
	}
	
	/**
	 * Returns the minimum number of players for the board game.
	 * @return the minimum number of players
	 */
	public int getMin() {
		return Min;
	}
	
	/**
	 * Returns the maximum number of players for the board game.
	 * @return the maximum number of players
	 */
	public int getMax() {
		return Max;
	}
	
	/**
	 * Sets the maximum number of players for the board game.
	 * @param Max the maximum number of players
	 */
	public void setMax(int Max) {
		this.Max = Max;
	}

	/**
	 * Returns the developers of the board game.
	 * @return the developers of the board game
	 */
	public String getDevelopers() {
		return developers;
	}
	
	/**
	 * Sets the developers of the board game.
	 * @param developers the developers of the board game
	 */
	public void setDevelopers(String developers) {
		this.developers = developers;
	}
	
	/**
	 * Sets the range of players for the board game.
	 * @param x the minimum number of players
	 * @param y the maximum number of players
	 */
	public void setRange(int x, int y) {
		Range = x + "-" + y;
	}
	
	/**
	 * Returns the range of players for the board game.
	 * @return the range of players for the board game
	 */
	public String getRange() {
		return Range;
	}

	// override toString method to return information about the toy as a string
	
	/**
	 * Returns a string representation of the board game toy.
	 * @return a string representation of the board game toy
	 */
	@Override
	public String toString() {
		return "Category: BoardGame," + " Serial Number:" +getS_N()+ "," + " Name:" + getName()+ "," + " Brand:" + getBrand()+ "," +  " Cost:" + getPrice() +","+ " Stock:" + getCount()+"," +" Appropriate Age:" + getAge()+"," +" Num Players:" + getRange() +","+" Designer(s):" + getDevelopers();
}
	/**

	Returns a formatted string representation of the Board_Games object's properties.
	The format of the string is "S_N;Name;Brand;Price;Count;Age;Range;Developers".
	@return the formatted string representation of the Board_Games object's properties
	*/
	public String format() {
	return getS_N() + ";" + getName() + ";" + getBrand() + ";" + getPrice() + ";" + getCount() + ";" + getAge() + ";" + getRange() + ";" + getDevelopers();
	}
}



