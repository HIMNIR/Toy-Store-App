/**

This class represents a toy of the category Figures. It extends the Toy class and includes

an additional field for the type of the figure.
*/
package model;
public class Figures extends Toy {
// A String field to store the type of the figure
private String type;

/**

Getter method for the type of the figure.
@return the type of the figure
*/
public String getType() {
return type;
}
/**

Setter method for the type of the figure.
@param type the type of the figure
*/
public void setType(String type) {
this.type = type;
}
/**

Constructor for creating a Figures object with the given values.
@param sin the serial number of the toy
@param item the name of the toy
@param brand the brand of the toy
@param price the price of the toy
@param stock the stock of the toy
@param age the age restriction of the toy
@param type the type of the figure
*/
public Figures(String sin, String item, String brand, double price, int stock, int age, String type) {
super(sin, item, brand, price, stock, age);
this.type = type;
}
/**

Returns a custom string representation of the Figures object.
@return a string representation of the Figures object
*/
@Override
public String toString() {
	return "Category: Figure,"+ " Serial Number:" +getS_N()+","+ " Name:" + getName()+","+ " Brand:" + getBrand()+ "," + " Cost:" + getPrice()+ "," + " Stock:" + getCount()+ "," +" Appropriate Age:" +getAge()+ "," + " Classification:" + getType();
}

/**

Returns a semicolon-separated string of all attributes of the Figures object.
Overrides the format method from the Toy class.
@return a semicolon-separated string of all attributes of the Figures object
*/
@Override
public String format() {
	return getS_N()+";" + getName()+";" + getBrand()+";" + getPrice()+";" + getCount()+";" +getAge()+";" + getType();
}
}


