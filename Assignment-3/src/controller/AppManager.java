package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javafx.scene.control.TextField;
import model.Animals;
import model.Board_Games;
import model.CustomExeptionClass;
import model.Figures;
import model.Puzzles;
import model.Toy;




/**
 * 
 * A class to manage the application's toy inventory.
 * 
 * Extends AppMenu class to inherit the menu interface for user interaction.
 */
public class AppManager extends SceneController{

	static ArrayList<Toy> arrList = new ArrayList<Toy>(); // ArrayList to store all the Toy objects
	private static File f = new File("res/toys.txt"); // File object for the text file that stores the toy data

	/**
	 * 
	 * Constructor to create an instance of AppManager and load toy data from the
	 * text file.
	 */
	public AppManager() {
		loadFile();
	}

	/**
	 * 
	 * Method to load toy data from the text file and create Toy objects. Uses
	 * BufferedReader and FileReader objects to read from the text file. Each line
	 * of the text file is split into an array of Strings to create Toy objects. Toy
	 * objects are added to the ArrayList. If any error occurs during file reading,
	 * it is printed to the console.
	 */
	public static void loadFile() {
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line;
			int count = 0;
			while ((line = br.readLine()) != null) {
				count++;
				String[] split = line.split(";");
				if (split[0].charAt(0) == '0' || split[0].charAt(0) == '1') {
					arrList.add(new Figures(split[0], split[1], split[2], Double.parseDouble(split[3]),
							Integer.parseInt(split[4]), Integer.parseInt(split[5]), split[6]));
				} else if (split[0].charAt(0) == '2' || split[0].charAt(0) == '3') {
					arrList.add(new Animals(split[0], split[1], split[2], Double.parseDouble(split[3]),
							Integer.parseInt(split[4]), Integer.parseInt(split[5]), split[6], split[7]));
				} else if (split[0].charAt(0) == '4' || split[0].charAt(0) == '5' || split[0].charAt(0) == '6') {
					arrList.add(new Puzzles(split[0], split[1], split[2], Double.parseDouble(split[3]),
							Integer.parseInt(split[4]), Integer.parseInt(split[5]), split[6]));
				} else if (split[0].charAt(0) == '7' || split[0].charAt(0) == '8' || split[0].charAt(0) == '9') {
					String[] split2 = split[6].split("-");
					arrList.add(new Board_Games(split[0], split[1], split[2], Double.parseDouble(split[3]),
							Integer.parseInt(split[4]), Integer.parseInt(split[5]), Integer.parseInt(split2[0]),
							Integer.parseInt(split2[1]), split[7]));
				}
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Method to save toy data to the text file. Uses FileWriter and PrintWriter
	 * objects to write to the text file. Each Toy object in the ArrayList is
	 * formatted into a String using the format method of the Toy class. The
	 * formatted String is written to the text file. If any error occurs during file
	 * writing, it is printed to the console.
	 */

	public static void saveFile() {
		// Create a FileWriter and PrintWriter objects to write to the text file
		try {
			FileWriter fw = new FileWriter("res/toys.txt");
			PrintWriter pw = new PrintWriter(fw);
			// Write each Toy object to the file
			for (Toy toys : arrList) {
				pw.println(toys.format());
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Returns an ArrayList of Toy objects that contain the specified string in their name.
	 * @param x the input string to search for in toy names
	 * @return an ArrayList of Toy objects containing the specified string
	 */
	public static ArrayList<Toy> purchaseName(String x) {
	    ArrayList<Toy> secondList = new ArrayList<Toy>();
	    String input = x.toLowerCase();
	    int count = 0;
	    for (Toy toys : arrList) {
	        if (toys.getName().toLowerCase().contains(input)) {
	            secondList.add(toys);
	            count++;
	        }
	    }
	    return secondList;
	}

	/**
	 * Returns an ArrayList of Toy objects that have the specified serial number.
	 * @param x the serial number to search for
	 * @return an ArrayList of Toy objects with the specified serial number
	 */
	public static ArrayList<Toy> purchaseS_N(String x) {
	    boolean digits = true;
	    ArrayList<Toy> secondList = new ArrayList<Toy>();
	    boolean found = false;
	    for (Toy toys : arrList) {
	        if (toys.getS_N().contains(x)) {
	            found = true;
	            secondList.add(toys);    
	        }
	        else {
	            // Do nothing
	        }
	    }
	    return secondList;
	}

	/**
	 * Removes and returns an ArrayList of Toy objects that have the specified serial number.
	 * @param x the serial number to search for and remove
	 * @return an ArrayList of Toy objects with the specified serial number that have been removed from the main ArrayList
	 */
	public static ArrayList<Toy> remove(String x) {
	    boolean digits = true;
	    ArrayList<Toy> secondList = new ArrayList<Toy>();
	    boolean found = false;
	    for (Toy toys : arrList) {
	        if (toys.getS_N().contains(x)) {
	            found = true;
	            secondList.add(toys);    
	        }
	    }
	    arrList.removeAll(secondList);
	    return secondList;
	}

	/**
	 * Returns an ArrayList of Toy objects that are of the specified type.
	 * @param x the type of toy to search for
	 * @return an ArrayList of Toy objects with the specified type
	 */
	public static ArrayList<Toy> purchaseType(String x) {
	    ArrayList<Toy> secondList = new ArrayList<Toy>();
	    if (x.equalsIgnoreCase("Figures")) {
	        System.out.println(x);
	        for (Toy toys : arrList) {
	            if (toys instanceof Figures) {
	                secondList.add(toys);
	            }
	            else {
	                // Do nothing
	            } 
	        }
	    }
	    else if (x.equalsIgnoreCase("Animals")) {
	        for (Toy toys : arrList) {
	            if (toys instanceof Animals) {
	                secondList.add(toys);
	            }
	            else {
	                // Do nothing
	            }
	        }
	    }
	    else if (x.equalsIgnoreCase("Puzzles")) {
	        for (Toy toys : arrList) {
	            if (toys instanceof Puzzles) {
	                secondList.add(toys);
	            }
	            else {
	                // Do nothing
	            }
	        }
	    }
	    else if (x.equalsIgnoreCase("Board_Games")) {
	        for (Toy toys : arrList) {
	            if (toys instanceof Board_Games) {
	                secondList.add(toys);
	            }
	            else {
	                // Do nothing
	            }
	        }
	    }
	    return secondList;
	}

	/**
	 * Validates a string as a serial number for a toy.
	 * @param x the string to validate
	 * @return true if the string is a valid serial number, false otherwise
	 */
	
	public static Boolean inputSN(String x) {
		try {
			
		
			String input = x;
			boolean digits = true;
			for (int i = 0; i < input.length(); i++) {
				if (!Character.isDigit(input.charAt(i))) {
					digits = false;
				}
			}
			for ( Toy toys : arrList) {
                if ( toys.getS_N().equals(input)) {
                
                   return false;
               
                }
			}
			if (digits == false) {
			
				return false;
			}
			if (input.length() != 10) {
			
				return false;
			} else {
				return true;
			}

//		for (Toy toys : arrList) {
//			if (toys.getS_N().contains(input)) {
//				found = true;
//
//			}

		} catch (InputMismatchException e) {
			
			inputSN(x);
		}
		return null;

	}
	/**
	 * Adds a new figure to the inventory.
	 *
	 * @param SN    the serial number of the figure
	 * @param name  the name of the figure
	 * @param brand the brand of the figure
	 * @param price the price of the figure
	 * @param stock the stock of the figure
	 * @param age   the age range for which the figure is appropriate
	 * @param type  the type of figure (a for action figure, d for doll, h for horse)
	 * @throws CustomExeptionClass if price, stock, or age are negative or if the type is not a, d, or h
	 */
	
	
	public static void addFigures(String SN, String name, String brand, double price, int stock, int age, String type) throws CustomExeptionClass {
		
			
			if(price<0) {
				String message = "price cant be less than 0";
				throw new CustomExeptionClass(message);
			}
			
			if(stock<0) {
				String message = "stock cant be less than 0";
				throw new CustomExeptionClass(message);
			}
			
			if(age<0) {
				String message = "age cant be less than 0";
				throw new CustomExeptionClass(message);
			}
			String parambb = type ;
			parambb = parambb.toUpperCase();
			if (parambb.equalsIgnoreCase("a") || parambb.equalsIgnoreCase("d") || parambb.equalsIgnoreCase("h")) {
				arrList.add(new Figures( SN, name, brand, price, stock, age, parambb));
				saveFile();
			} else {
				String message = "change to appropriate classification";
				throw new CustomExeptionClass(message);
				
			}
	}

	/**
	 * Adds a new animal toy to the inventory.
	 *
	 * @param SN       the serial number of the animal toy
	 * @param name     the name of the animal toy
	 * @param brand    the brand of the animal toy
	 * @param price    the price of the animal toy
	 * @param stock    the stock of the animal toy
	 * @param age      the age range for which the animal toy is appropriate
	 * @param Material the material of the animal toy
	 * @param size     the size of the animal toy (s for small, m for medium, l for large)
	 * @throws CustomExeptionClass if price, stock, or age are negative or if the size is not s, m, or l
	 */
	public static void addAnimals(String SN, String name, String brand, double price, int stock, int age, String Material,String size) throws CustomExeptionClass {
		
			if(price<0) {
				String message = "price cant be less than 0";
				throw new CustomExeptionClass(message);
			}
		
			if(stock<0) {
				String message = "stock cant be less than 0";
				throw new CustomExeptionClass(message);
			}
			
			if(age<0) {
				String message = "age cant be less than 0";
				throw new CustomExeptionClass(message);
			}
			
			String parambb = size ;
			parambb = parambb.toUpperCase();
			if (parambb.equalsIgnoreCase("s") || parambb.equalsIgnoreCase("m") || parambb.equalsIgnoreCase("l")) {
				arrList.add(new Animals( SN, name, brand, price, stock, age, Material, parambb));
				saveFile();
			} else {
				String message = "change to appropriate classification";
				throw new CustomExeptionClass(message);
				
				
			}
	}
	/**
	 * Adds a new puzzle to the inventory.
	 *
	 * @param SN   the serial number of the puzzle
	 * @param name the name of the puzzle
	 * @param brand the brand of the puzzle
	 * @param price the price of the puzzle
	 * @param stock the stock of the puzzle
	 * @param age   the age range for which the puzzle is appropriate
	 * @param type  the type of puzzle (m for mosaic, c for crossword, l for logic, t for trivia, r for riddle)
	 * @throws CustomExeptionClass if price, stock, or age are negative or if the type is not m, c, l, t, or r
	 */
	public static void addPuzzles(String SN, String name, String brand, double price, int stock, int age, String type) throws CustomExeptionClass {
	
		
		if(price<0) {
			String message = "price cant be less than 0";
			throw new CustomExeptionClass(message);
		}
		
		if(stock<0) {
			String message = "stock cant be less than 0";
			throw new CustomExeptionClass(message);
		}
		
		if(age<0) {
			String message = "age cant be less than 0";
			throw new CustomExeptionClass(message);
		}
		String parambb = type ;
		parambb = parambb.toUpperCase();
		if (parambb.equalsIgnoreCase("m") || parambb.equalsIgnoreCase("c") || parambb.equalsIgnoreCase("l") || parambb.equalsIgnoreCase("t") || parambb.equalsIgnoreCase("r")) {
			arrList.add(new Puzzles( SN, name, brand, price, stock, age, parambb));
			saveFile();
		} else {
			String message = "change to appropriate classification";
			throw new CustomExeptionClass(message);
			
			
		}
}
	
	/**
	 * Adds a new board game to the inventory.
	 *
	 * @param SN   the serial number of the board game
	 * @param name the name of the board game
	 * @param brand the brand of the board game
	 * @param price the price of the board game
	 * @param stock the stock of the board game
	 * @param age   the age range for which the board game is appropriate
	 * @param min   the minimum number of players for the board game
	 * @param max   the maximum number of players for the board game
	 * @param size  the size of the board game (e.g. standard, travel, deluxe)
	 * @throws CustomExeptionClass if price, stock, or age are negative or if min is greater than max
	 */
	public static void addBoard_Games(String SN, String name, String brand, double price, int stock, int age, int min ,int max ,String size) throws CustomExeptionClass {
		
		if(price<0) {
			String message = "price cant be less than 0";
			throw new CustomExeptionClass(message);
		}
	
		if(stock<0) {
			String message = "stock cant be less than 0";
			throw new CustomExeptionClass(message);
		}
		
		if(age<0) {
			String message = "age cant be less than 0";
			throw new CustomExeptionClass(message);
		}
		if ( min > max) {
			String message = "min !> max";
			throw new CustomExeptionClass(message);
		}
		
		String parambb = size ;
	
	
			arrList.add(new Board_Games( SN, name, brand, price, stock, age, min,max, parambb));
			saveFile();
		
}
	
}

