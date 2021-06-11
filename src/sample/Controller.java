package sample;

import com.jfoenix.controls.JFXButton;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class Controller implements Initializable {

    @FXML
    private MenuItem newManager;

    @FXML
    private Menu managers;

    @FXML
    private BorderPane borderPane;
    
    @FXML
    private JFXButton newManagerBtn;

    @FXML
    private void newManagerAction() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/NewManager/newManager.fxml"));
        Parent parent = loader.load();
        borderPane.setCenter(parent);
    }
    
    @FXML
    private void newManagerBtnAction() throws IOException{
	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/NewManager/newManager.fxml"));
        Parent parent = loader.load();
        borderPane.setCenter(parent);
    }
    
    String iconPath = "C:\\Users\\Onyekachukwu\\Documents\\NetBeansProjects\\myProject\\src\\Icons\\icons8_manager_26px_1.png";
    String correctIconPath = iconPath.replace("\\", "/");
    
    // adding icon to button
    public void graphicAdder() throws FileNotFoundException{
	FileInputStream stream = new FileInputStream(correctIconPath);
	Image icon = new Image(stream);
	
	ImageView imageView = new ImageView(icon);
	imageView.setPreserveRatio(true);
	imageView.setSmooth(true);
	imageView.maxHeight(100);
	imageView.maxWidth(100);
	
	Label label = new Label("New Manager");
	label.setFont(Font.font(15));
	
	VBox vb = new VBox(imageView,label);
	vb.setSpacing(20);
	vb.setAlignment(Pos.CENTER);
	
	newManagerBtn.setGraphic(vb);
	newManagerBtn.setText(null);
	newManagerBtn.setRipplerFill(Paint.valueOf("gray"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
	try {
	    graphicAdder();
	} catch (FileNotFoundException ex) {
	    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
}