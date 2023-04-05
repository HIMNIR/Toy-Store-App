package controller;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.CustomExeptionClass;
import model.Figures;

public class AddSceneController {
	  String logFile = "res/actionLog.txt";
	/**
	 * Controller for the "Add Scene" view. Handles user input and updates the application model accordingly.
	 */
	private Stage stage;
	@FXML
	private MenuButton dropDown;

	@FXML
	private Button addButton;
	@FXML
	private Button BackButton;
	@FXML
	private Button mainButton;
	@FXML
	private Button removeButton;

	@FXML
	private MenuItem figureDown;

	@FXML
	private MenuItem animalDown;

	@FXML
	private MenuItem puzzlesDown;

	@FXML
	private MenuItem boardDown;

	@FXML
	private TextField errorPage;
	@FXML
	private TextField nameInput;

	@FXML
	private TextField snInput;

	@FXML
	private TextField brandInput;

	@FXML
	private TextField priceInput;

	@FXML
	private TextField stockInput;

	@FXML
	private TextField ageInput;

	@FXML
	private TextField figInput;

	@FXML
	private TextField animalInput;

	@FXML
	private TextField puzInput;

	@FXML
	private TextField animalInputSize;

	@FXML
	private TextField minPlayers;

	@FXML
	private TextField maxPlayers;

	@FXML
	private TextField developers;
	   FileHandler fh;
		private static final Logger logger = Logger.getLogger("MyLogger");


	    private void Logger() {
	        try {
	        
	            String logFilePath = logFile;
	           fh = new FileHandler(logFilePath, true);
	            fh.setLevel(Level.ALL);
	            logger.addHandler(fh);
	            fh.setFormatter(new SimpleFormatter());
	        } catch (IOException e) {
	            System.err.println("Error creating log file: " + e.getMessage());
	        } catch (SecurityException e) {
	            System.err.println("Security Exception: " + e.getMessage());
	        }
	    }

    /**
     * Navigates to the main scene when the corresponding button is pressed.
     */
	@FXML
	void mainHandler() {
		Logger();
	    logger.addHandler(fh); // add the FileHandler to the logger
        logger.info("Navigated to mainPage");
		try {
			Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource("../view/scene.fxml"));
			stage = (Stage) mainButton.getScene().getWindow();
			stage.setScene(new Scene(root,1020,774));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method loads the "removeScene.fxml" file and sets it as the scene for the primary stage.
	 * It is triggered when the "Remove Product" button is pressed.
	 * @FXML
	 */
	@FXML
	void removeHandler() {
		Logger();
	    logger.addHandler(fh); // add the FileHandler to the logger
        logger.info("Navigated to removedPage");
		try {
			Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource("../view/removeScene.fxml"));
			stage = (Stage) removeButton.getScene().getWindow();
			stage.setScene(new Scene(root,1020,774));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * This method checks if all the input fields are not null.
	 * @return true if all input fields are not null, false otherwise.
	 */
	
	public boolean nullCheck() {
		if ((animalInputSize != null) && (puzInput != null) && (animalInput != null) && (figInput != null)
				&& (ageInput != null) && (stockInput != null) && (priceInput != null) && (brandInput != null)
				&& (snInput != null) && (nameInput != null)) {
			return true;
		}

		return false;

	}
	/**
	 * This method hides the "Back" button and the error message.
	 * It is triggered when the "Back" button is pressed.
	 * @FXML
	 */

	@FXML
	void backHandler() {
		Logger();
	    logger.addHandler(fh); // add the FileHandler to the logger
        logger.info("back button pressed");
		BackButton.setVisible(false);
		errorPage.setVisible(false);
	}
	/**
	 * This method adds a product to the inventory.
	 * It first checks the drop-down menu to determine the type of the product.
	 * Then, it validates the input fields and calls the appropriate add method in the AppManager class.
	 * If an error occurs, it displays an error message on the screen.
	 * @throws CustomExeptionClass when a custom exception occurs.
	 * @FXML
	 */
	
	@FXML
	void addHandler() throws CustomExeptionClass {
		Logger();
	    logger.addHandler(fh); // add the FileHandler to the logger
        logger.info("add button pressed");
		try {
			if (dropDown.getText().equals("Figures")) {
				boolean ready = AppManager.inputSN(snInput.getText());

				if (nullCheck() && ((snInput.getText().charAt(0) == '0') || (snInput.getText().charAt(0) == '1'))
						&& ready) {
					AppManager.addFigures(snInput.getText(), nameInput.getText(), brandInput.getText(),
							Double.parseDouble(priceInput.getText()), Integer.parseInt(stockInput.getText()),
							Integer.parseInt(ageInput.getText()), figInput.getText());
					displayMessage("Product added successfully");

				} else {
					displayMessage("Couldnt add product please double check");
				}

			}
			if (dropDown.getText().equals("Animals")) {
				boolean ready = AppManager.inputSN(snInput.getText());

				if (nullCheck() && ((snInput.getText().charAt(0) == '2') || (snInput.getText().charAt(0) == '3'))
						&& ready) {
					AppManager.addAnimals(snInput.getText(), nameInput.getText(), brandInput.getText(),
							Double.parseDouble(priceInput.getText()), Integer.parseInt(stockInput.getText()),
							Integer.parseInt(ageInput.getText()), animalInput.getText(), animalInputSize.getText());
					displayMessage("Product added successfully");

				} else {
					displayMessage("Couldnt add product please double check");
				}

			}
			if (dropDown.getText().equals("Puzzles")) {
				boolean ready = AppManager.inputSN(snInput.getText());

				if (nullCheck() && ((snInput.getText().charAt(0) == '4') || (snInput.getText().charAt(0) == '5')|| (snInput.getText().charAt(0) == '6'))
						&& ready) {
					AppManager.addPuzzles(snInput.getText(), nameInput.getText(), brandInput.getText(),
							Double.parseDouble(priceInput.getText()), Integer.parseInt(stockInput.getText()),
							Integer.parseInt(ageInput.getText()), puzInput.getText());
					displayMessage("Product added successfully");
				

				} else {
					displayMessage("Couldnt add product please double check");
				
				}
			}
			if (dropDown.getText().equals("Board_Games")) {
				boolean ready = AppManager.inputSN(snInput.getText());

				if (nullCheck() && ((snInput.getText().charAt(0) == '7') || (snInput.getText().charAt(0) == '8')|| (snInput.getText().charAt(0) == '9'))
						&& ready) {
					AppManager.addBoard_Games(snInput.getText(), nameInput.getText(), brandInput.getText(),
							Double.parseDouble(priceInput.getText()), Integer.parseInt(stockInput.getText()),
							Integer.parseInt(ageInput.getText()), Integer.parseInt(minPlayers.getText()), Integer.parseInt(maxPlayers.getText()), developers.getText());
					displayMessage("Product added successfully");

				} else {
					displayMessage("Couldnt add product please double check");
				}
				
			}
		} catch (CustomExeptionClass e) {
			displayMessage(e.getMessage());

		} catch (NumberFormatException e) {
			displayMessage("Age price and stock must be digits");

		}
		catch (Exception e) {
			displayMessage("Error: couldnt add product");

		}
	}
	/**

	Sets the error message and displays the error page.
	@param x the error message to be displayed
	*/

	public void displayMessage(String x) {
		BackButton.setVisible(true);
		errorPage.setVisible(true);
		errorPage.setStyle("-fx-font-size: 36px;");
		errorPage.setStyle("-fx-font-family: MS Gothic;");
		errorPage.setText(x);
	}
	/** Sets the disable state of several GUI components.
	@param a the boolean value to set the disable state to
	*/

	public void setDisable(boolean a) {
		developers.setDisable(a);
		maxPlayers.setDisable(a);
		minPlayers.setDisable(a);
		puzInput.setDisable(a);
		figInput.setDisable(a);
		animalInput.setDisable(a);
		animalInputSize.setDisable(a);

	}

	
	@FXML
	void chooseAnimals(ActionEvent event) {
		Logger();
	    logger.addHandler(fh); // add the FileHandler to the logger
        logger.info("Animals selected");
		dropDown.setText("Animals");
		setDisable(true);
		animalInput.setDisable(false);
		animalInputSize.setDisable(false);
		addButton.setVisible(true);
	}

	@FXML
	void chooseBoard(ActionEvent event) {
		Logger();
	    logger.addHandler(fh); // add the FileHandler to the logger
        logger.info("Board selected");
		dropDown.setText("Board_Games");
		setDisable(true);
		developers.setDisable(false);
		maxPlayers.setDisable(false);
		minPlayers.setDisable(false);
		addButton.setVisible(true);
	}

	@FXML
	void chooseFigure(ActionEvent event) {
		Logger();
	    logger.addHandler(fh); // add the FileHandler to the logger
        logger.info("Figures selected");
		dropDown.setText("Figures");
		setDisable(true);
		figInput.setDisable(false);
		addButton.setVisible(true);
	}

	@FXML
	void choosePuzzles(ActionEvent event) {
		Logger();
	    logger.addHandler(fh); // add the FileHandler to the logger
        logger.info("Puzzles selected");
		dropDown.setText("Puzzles");
		setDisable(true);
		puzInput.setDisable(false);
		addButton.setVisible(true);
	}


}
