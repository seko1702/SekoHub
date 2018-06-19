package control;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ParteiErstellenController {
	
	@FXML
	private ComboBox<String> parteiartComboBox;
	@FXML
	private GridPane natuerlicheParteiPane, juristischeParteiPane;
	@FXML
	private AnchorPane blankPane;
	
	@FXML
	public void parteiartComboBox() {
		String parteiart = parteiartComboBox.getSelectionModel().getSelectedItem();
		
		if(parteiart.equals("Natürliche Partei")) {
			juristischeParteiPane.setVisible(false);
			blankPane.setVisible(false);
			natuerlicheParteiPane.setVisible(true);
		}
		else if(parteiart.equals("Juristische Partei")) {
			blankPane.setVisible(false);
			natuerlicheParteiPane.setVisible(false);
			juristischeParteiPane.setVisible(true);
		}
	}
	
	@FXML
	public void abbrechenBtnPressed(ActionEvent event) throws IOException {
		
		Parent parent = FXMLLoader.load(getClass().getResource("/view/Startseite.fxml"));
		Scene scene = new Scene(parent);
		
		Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.setMaximized(true);
		System.out.println(window.isMaximized());
		window.show();
	}
}
