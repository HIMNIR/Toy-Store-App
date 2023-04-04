/**

The Animals class is a subclass of Toy class representing a toy that is an animal figure.
It contains attributes such as material and size.
It also overrides the toString() and format() methods from the Toy class.
*/
package model;



public class Animals extends Toy{
private String material;
private String size;
/**
 * Returns the material of the animal toy.
 * @return the material of the animal toy
 */
public String getMaterial() {
	return material;
}

/**
 * Sets the material of the animal toy.
 * @param material the material of the animal toy
 */
public void setMaterial(String material) {
	this.material = material;
}

/**
 * Returns the size of the animal toy.
 * @return the size of the animal toy
 */
public String getSize() {
	return size;
}

/**
 * Sets the size of the animal toy.
 * @param size the size of the animal toy
 */
public void setSize(String size) {
	this.size = size;
}

/**
 * Constructs an Animals object with the given parameters.
 * @param S_N the serial number of the animal toy
 * @param name the name of the animal toy
 * @param brand the brand of the animal toy
 * @param price the price of the animal toy
 * @param count the number of the animal toys in stock
 * @param age the age restriction of the animal toy
 * @param material the material of the animal toy
 * @param size the size of the animal toy
 */
public Animals(String sin, String item, String brand, double price, int stock, int age, String material, String size) {
	super(sin, item, brand, price, stock, age);
	this.material = material;
	this.size=size;
}
/**
 * Returns a string representation of the Animals object.
 * @return a string representation of the Animals object
 */
@Override
public String toString() {
	return "Category: Animals," + " Serial Number:" +getS_N()+ "," + " Name:" + getName()+"," + " Brand: " + getBrand()+"," +  " Cost:" + getPrice()+"," + " Stock:" + getCount()+"," + " Appropriate Age:" +getAge() + "," + " Material:" + getMaterial() + "," + " Size:" + getSize();
	
}

/**
 * Returns a formatted string representation of the Animals object for writing to a file.
 * @return a formatted string representation of the Animals object
 */

public String format() {
	 return getS_N()+";" + getName()+";" + getBrand()+";" + getPrice() +";" + getCount()+";" +getAge()+";"+ getMaterial()+";"+getSize(); 
 }
}


