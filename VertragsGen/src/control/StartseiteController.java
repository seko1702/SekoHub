package control;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartseiteController {
	
	@FXML
	public void addParteiBtnPressed(ActionEvent event) throws IOException {
		
		Parent parteiErstellen = FXMLLoader.load(getClass().getResource("/view/ParteiErstellen.fxml"));
		Scene scene = new Scene(parteiErstellen);
		
		Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.setMaximized(true);
		window.show();
	}
}
