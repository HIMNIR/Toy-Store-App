package controller;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Toy;

public class SceneController {
	ObservableList<Toy> snList ;
	ObservableList<Toy> nameList;
	ObservableList<Toy> typeList;
	private static String nameText;
	@FXML
	private Button home;
	@FXML
	private ListView<Toy> displayList;
	@FXML
	private Button add;

	@FXML
	private Button remove;

	@FXML
	private Label Header;

	@FXML
	private RadioButton bySN;

	@FXML
	private ToggleGroup group1;

	@FXML
	private RadioButton byName;

	@FXML
	private RadioButton byType;

	@FXML
	private TextField snInput;

	@FXML
	private TextField nameInput;

	@FXML
	private Label enterName;
	@FXML
	private Label enterSN;
	@FXML
	private Label enterType;
	@FXML
	private TextField typeInput;

	@FXML
	private Button Submit;

	@FXML
	private Button reset;

    @FXML
    private Button buyButton;

    @FXML
    private TextField complete;
    
    @FXML
    private TextField noStock;

    @FXML
    private Button back;
    
	private Stage stage;

	/**
	Loads the "addScene.fxml" view and displays it on the current window.
	This method is triggered by the "Add" button on the main page.
	@param event the ActionEvent object that triggered the method
	*/
	@FXML
	void addPage(ActionEvent event) {
		try {
			Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource("../view/addScene.fxml"));
			stage = (Stage) add.getScene().getWindow();
			stage.setScene(new Scene(root,1020,774));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
																									
	}

	@FXML
	void homePage(ActionEvent event) {

	}
	/**
	Loads the "removeScene.fxml" view and displays it on the current window.
	This method is triggered by the "Remove" button on the main page.
	@param event the ActionEvent object that triggered the method
	*/

	@FXML
	void removePage(ActionEvent event) {

		try {
			Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource("../view/removeScene.fxml"));
			stage = (Stage) remove.getScene().getWindow();
			stage.setScene(new Scene(root,1020,774));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**

	Method to hide certain UI elements when back button is clicked
	@param event Action event for back button
	*/
	@FXML
	void backHandler(ActionEvent event) {
		noStock.setVisible(false);
		complete.setVisible(false);
		back.setVisible(false);
	}
	
	/**

	Method to handle buying a toy when buy button is clicked
	@param event Action event for buy button
	*/
	@FXML
	void buyHandler(ActionEvent event) {
		for (Toy toys : AppManager.arrList) {
			if (toys.equals(displayList.getSelectionModel().getSelectedItem())) {
				if (toys.getCount() != 0) {
					toys.setCount(toys.getCount() - 1);
					AppManager.saveFile();
					complete.setVisible(true);
					back.setVisible(true);
				}
				else {
					
					noStock.setVisible(true);
					back.setVisible(true);
				}
			}
		}
		
	}
	/**

	Method to display the list of toys based on user input

	@param event Action event for submit button
	*/

	@FXML
	void subHandler(ActionEvent event) {
		buyButton.setVisible(true);
		if (byName.isSelected()) {
			String nameText = nameInput.getText();
			System.out.println(nameText);
			ArrayList<Toy> purchaseName = AppManager.purchaseName(nameText);
			 nameList = FXCollections.observableArrayList(purchaseName);
			displayList.getItems().addAll(nameList);
		} else if (bySN.isSelected()) {
			String snText = snInput.getText();
			ArrayList<Toy> purchaseSN = AppManager.purchaseS_N(snText);
			 snList = FXCollections.observableArrayList(purchaseSN);
			displayList.getItems().addAll(snList);
		}

		else if (byType.isSelected()) {
			String typeText = typeInput.getText();
			ArrayList<Toy> purchaseType = AppManager.purchaseType(typeText);
			 typeList = FXCollections.observableArrayList(purchaseType);
			displayList.getItems().addAll(typeList);
		}

	}
	/**

	Method to make certain UI elements visible
	*/
	public void visible() {
		nameInput.setVisible(true);
		snInput.setVisible(true);
		typeInput.setVisible(true);
		enterName.setVisible(true);
		enterSN.setVisible(true);
		enterType.setVisible(true);
		Submit.setVisible(true);
		reset.setVisible(true);
	
	}
	/** method to change color of certain labels and disable certain text fields*/
	public void colorCode1() {
		snInput.setDisable(false);
		typeInput.setDisable(true);
		nameInput.setDisable(true);
		enterSN.setTextFill(Color.RED);
		enterName.setTextFill(Color.WHITE);
		enterType.setTextFill(Color.WHITE);
	}
	/** method to change color of certain labels and disable certain text fields*/
	public void colorCode2() {
		typeInput.setDisable(false);
		nameInput.setDisable(true);
		snInput.setDisable(true);
		enterType.setTextFill(Color.RED);
		enterSN.setTextFill(Color.WHITE);
		enterName.setTextFill(Color.WHITE);
	}
	/** method to change color of certain labels and disable certain text fields*/
	public void colorCode3() {
		nameInput.setDisable(false);
		typeInput.setDisable(true);
		snInput.setDisable(true);
		enterName.setTextFill(Color.RED);
		enterSN.setTextFill(Color.WHITE);
		enterType.setTextFill(Color.WHITE);
	}

	public void colorReset() {
		enterName.setTextFill(Color.WHITE);
		enterSN.setTextFill(Color.WHITE);
		enterType.setTextFill(Color.WHITE);
		nameInput.setDisable(false);
		typeInput.setDisable(false);
		snInput.setDisable(false);
	}

	/**

	This method is called when the "bySN" checkbox is selected.
	It calls the "visible" and "colorCode1" methods if the "bySName" checkbox is selected.
	@param event - the event triggered by the "byName" checkbox selection
	*/
	
	@FXML
	void snHandler(ActionEvent event) {
		if (bySN.isSelected()) {
			visible();
			colorCode1();
		}

	}
	/**

	This method is called when the "byType" checkbox is selected.
	It calls the "visible" and "colorCode2" methods if the "byType" checkbox is selected.
	@param event - the event triggered by the "byType" checkbox selection
	*/
	@FXML
	void typeHandler(ActionEvent event) {
		if (byType.isSelected()) {
			visible();
			colorCode2();
		}
	}
	/**

	This method is called when the "byName" checkbox is selected.
	It calls the "visible" and "colorCode3" methods if the "byName" checkbox is selected.
	@param event - the event triggered by the "byName" checkbox selection
	*/
	@FXML
	void nameHandler(ActionEvent event) {
		if (byName.isSelected()) {
			visible();
			colorCode3();
		}

	}
	/**

	This method is called when the "Reset" button is clicked. It clears the items in the displayList
	depending on which checkbox is selected, clears the text inputs, and resets the checkbox selections.
	It also calls the "colorReset" method to reset the color of the text.
	@param event - the event triggered by the "Reset" button click
	*/
	@FXML
	void resetHandler(ActionEvent event) {
		if(bySN.isSelected()) {
		
			displayList.getItems().clear();
		}
		else if(byName.isSelected()) {
		
			displayList.getItems().clear();
		}
		else if(byType.isSelected()) {
			
			displayList.getItems().clear();
		}
		nameInput.deleteText(0, nameInput.getLength());
		byName.setSelected(false);
		snInput.deleteText(0, snInput.getLength());
		bySN.setSelected(false);
		typeInput.deleteText(0, typeInput.getLength());
		byType.setSelected(false);
		colorReset();
		
		
		
	}
	
}
