package model;



/**
 * The Toy class represents a toy that can be sold in a store.
 * This is an abstract class, so it cannot be instantiated directly.
 * Instead, subclasses of Toy must be created to represent specific types of toys.
 */
public abstract class Toy {
	
	// Fields for the toy's serial number, name, brand, price, count, and age range
	private String S_N;
	private String name;
	private String brand;
	private double price;
	private int count;
	private int age;
public Toy(String S_N, String name, String brand, double price, int count, int age) {
		
		this.S_N = S_N;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.count = count;
		this.age = age;

	}
	/**
	 * Getter method for the toy's serial number.
	 * @return The serial number of the toy.
	 */
	public String getS_N() {
		return S_N;
	}

	/**
	 * Setter method for the toy's serial number.
	 * @param s_N The serial number to set for the toy.
	 */
	public void setS_N(String s_N) {
		S_N = s_N;
	}

	/**
	 * Getter method for the toy's price.
	 * @return The price of the toy.
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Setter method for the toy's price.
	 * @param price The price to set for the toy.
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Getter method for the toy's name.
	 * @return The name of the toy.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method for the toy's name.
	 * @param name The name to set for the toy.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter method for the toy's count.
	 * @return The count of the toy.
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Setter method for the toy's count.
	 * @param count The count to set for the toy.
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * Getter method for the toy's age range.
	 * @return The age range of the toy.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Setter method for the toy's age range.
	 * @param age The age range to set for the toy.
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Getter method for the toy's brand.
	 * @return The brand of the toy.
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Setter method for the toy's brand.
	 * @param brand The brand to set for the toy.
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Abstract method that must be implemented by subclasses of Toy.
	 */
	public abstract String format();
	public abstract String toString();
	
	
} 





