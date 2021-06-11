package NewManager;

import java.io.FileNotFoundException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import tableModels.Models;

public class newManagerController implements Initializable {

    @FXML
    private TableView tableView;

    @FXML
    private TableColumn fieldCol;

    @FXML
    private TableColumn dataTypeCol;

    @FXML
    private TableColumn editRow;

    @FXML
    private VBox managerProperty;
    
    @FXML
    private TableColumn addRemoveCol;

    @FXML
    private Spinner numberOfCharsSpinner;

    ObservableList<Models> tableData = FXCollections.observableArrayList();

    public void addTotableData() throws FileNotFoundException {
	for (int i = 1; i < 3; i++) {
	    tableData.add(new Models());
	}
	tableView.setItems(tableData);
    }
    
    // this method will not be use in this class but in Model class
    public void addMoreRow(ObservableList<Models> data){
	tableView.setItems(data);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
	tableView.setEditable(false);

	try {
	    addTotableData();
	} catch (FileNotFoundException ex) {
	    Logger.getLogger(newManagerController.class.getName()).log(Level.SEVERE, null, ex);
	}

	tableView.setItems(tableData);
	
	fieldCol.setCellValueFactory(new PropertyValueFactory<>("field"));
	dataTypeCol.setCellValueFactory(new PropertyValueFactory<>("dataType"));
	editRow.setCellValueFactory(new PropertyValueFactory<>("imageView"));
	addRemoveCol.setCellValueFactory(new PropertyValueFactory<>("hb"));

	SpinnerValueFactory<Integer> numberOfCharsSpinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 200,
		50);
	this.numberOfCharsSpinner.setValueFactory(numberOfCharsSpinner);
	this.numberOfCharsSpinner.setEditable(true);

	this.numberOfCharsSpinner.setDisable(true);
    }
}
