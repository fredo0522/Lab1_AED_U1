package com.JavaFX.Lab1AED.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLWindowController implements Initializable{
	
	@FXML
	private ChoiceBox<String> sortChoice;
	
	@FXML
	private Button btnAction;
	
	@FXML
    private CheckBox manual;
	
	@FXML
    private TextField sizeArray;
	
	@FXML
    private TextArea textArea;
	
	@FXML
	public void organizeChoiceBox() {
		sortChoice.getItems().add("Ordenamiento Creciente");
		sortChoice.getItems().add("Ordenamiento Decreciente");
		sortChoice.getItems().add("Aleatorio");
		sortChoice.getItems().add("Desordenados en un %");
	}
	
	@FXML
	void visibleChoiceBox(ActionEvent event) {
		if(manual.isSelected()) {
			sortChoice.setDisable(true);
		}else {
			sortChoice.setDisable(false);
		}
    }
	
	@FXML
    void generateArray(ActionEvent event) {
		if (manual.isSelected()) {
			textArea.setText("Funciona para escribir valores");
		}else {
			textArea.setText("");
			int cantidades = Integer.valueOf(sizeArray.getText());
			for (int i = 0; i < cantidades; i++) {
				textArea.appendText("Funciona \n");
			}
		}
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		organizeChoiceBox();
	}
}
