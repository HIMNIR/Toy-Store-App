

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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Toy;

public class RemoveSceneController {
	private Stage stage;
    @FXML
    private Button mainPage;

    @FXML
    private Button addPage;

    @FXML
    private Button currentPage;

    @FXML
    private Label searchLabel;

    @FXML
    private Label searchLabel1;

    @FXML
    private Button removeButton;

    @FXML
    private TextField errorPage;
    @FXML
    private TextField snInput;

    @FXML
    private Button backButton;
    @FXML
    private Button searchButton;
	@FXML
	private ListView<Toy> displayList;
	
	ObservableList<Toy> typeList;
	/**

	This method is called when the "Back" button is clicked. It hides the errorPage and backButton.
	@param event - the event triggered by the "Back" button click
	*/
    @FXML
    void backHandler(ActionEvent event) {
    	errorPage.setVisible(false);
		backButton.setVisible(false);
    }
    /**

    This method is called when the "Main" button is clicked. It loads the main scene when called.
    @param event - the event triggered by the "Main" button click
    */
    @FXML
    void mainHandler(ActionEvent event) {
    	try {
			Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource("../view/scene.fxml"));
			stage = (Stage) mainPage.getScene().getWindow();
			stage.setScene(new Scene(root,1020,774));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /**

    This method is called when the "Search" button is clicked. It searches for a Toy object in the AppManager ArrayList
    with the same type as the input in snInput, removes it from the ArrayList, and displays the result in the displayList.
    @param event - the event triggered by the "Search" button click
    */
    @FXML
    void searchHandler(ActionEvent event) {
    	String typeText = snInput.getText();
		ArrayList<Toy> purchaseType = AppManager.remove(typeText);
		 typeList = FXCollections.observableArrayList(purchaseType);
		displayList.getItems().addAll(typeList);
    		
    }
    /**

    This method is called when the "Remove" button is clicked. It removes the selected item from the AppManager ArrayList,
    displays a success message, and updates the displayList. If the item cannot be found, it displays an error message.
    @param event - the event triggered by the "Remove" button click
    */
    @FXML
    void removeHandler(ActionEvent event) {
    	for (Toy toys : AppManager.arrList) {
			if (toys.equals(displayList.getSelectionModel().getSelectedItem())) {
				if (toys.getCount() != 0) {
					AppManager.arrList.remove(toys);
					AppManager.saveFile();
					errorPage.setVisible(true);
					errorPage.setText("Item has been removed");
					backButton.setVisible(true);
					displayList.getItems().clear();
					break;
				}
				else {
					
					errorPage.setVisible(true);
					errorPage.setText("Couldnt find item");
					backButton.setVisible(true);
				}
			}
    	}
		
    }
    
    /**

    This method is called when the "Add" button is clicked. It loads the add scene when called.
    @param event - the event triggered by the "Add" button click
    */
  @FXML
  void addHandler(ActionEvent event) {
  	try {
			Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource("../view/addScene.fxml"));
			stage = (Stage) addPage.getScene().getWindow();
			stage.setScene(new Scene(root,1020,774));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }



}

