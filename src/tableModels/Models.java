package tableModels;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class Models {
    private JFXTextField field;
    private JFXComboBox dataType;
    private ImageView imageView;
    private HBox hb;

    public void setHb(HBox hb) {
	this.hb = hb;
    }

    public HBox getHb() {
	return hb;
    }

    public void setImageView(ImageView imageView) {
	this.imageView = imageView;
    }

    public ImageView getImageView() {
	return imageView;
    }

    String iconPath = "C:\\Users\\Onyekachukwu\\Documents\\NetBeansProjects\\myProject\\src\\Icons\\SelectIcon.png";
    String correctPath = iconPath.replace("\\", "//");

    ObservableList<Models> tableData = FXCollections.observableArrayList();

    public Models() throws FileNotFoundException {
	this.field = new JFXTextField();
	this.dataType = new JFXComboBox(FXCollections.observableArrayList("Text", "Numbers", "Data", "Time", "DataTime",
		"Selection", "Multi-Selection", "Image"));
	Button b1 = new Button("+");
	b1.setOnAction(e -> {
	    try {
		for (int i = 1; i < 2; i++) {
		    try {
			tableData.add(new Models());
		    } catch (FileNotFoundException ex) {
			Logger.getLogger(Models.class.getName()).log(Level.SEVERE, null, ex);
		    }
		}
		String path = "\\NewManager\\newManager.fxml";
		String correctPath = path.replace("\\", "/");
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource(correctPath));
		loader.getController();
		Parent method = loader.load();
		
	    } catch (IOException ex) {
		Logger.getLogger(Models.class.getName()).log(Level.SEVERE, null, ex);
	    }
	});

	Button b0 = new Button("-");
	HBox hb2 = new HBox(b0);
	HBox.setHgrow(hb2, Priority.ALWAYS);

	hb2.setAlignment(Pos.CENTER_RIGHT);

	this.hb = new HBox(b1, hb2);
	hb.setAlignment(Pos.CENTER_LEFT);
	hb.setSpacing(20);

	FileInputStream inputStream = new FileInputStream(correctPath);
	Image icon = new Image(inputStream);

	this.imageView = new ImageView();
	imageView.setImage(icon);
	dataType.setPromptText("Data type");
	field.setPromptText("Field name");
    }

    public JFXTextField getField() {
	return field;
    }

    public JFXComboBox getDataType() {
	return dataType;
    }

    public void setField(JFXTextField field) {
	this.field = field;
    }

    public void setDataType(JFXComboBox dataType) {
	this.dataType = dataType;
    }

}
