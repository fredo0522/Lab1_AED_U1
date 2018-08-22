package com.Lab1AED.controller;

import java.net.URL;
import java.util.ResourceBundle;
import com.Lab1AED.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLWindowController implements Initializable{
	
	private Model worldModel;
	
	@FXML
	private ComboBox<String> sortChoice;
	
	@FXML
	private ComboBox<String> numberType;
	
	@FXML
	private Button btnAction;
	
	@FXML
    private CheckBox manual;
	
	@FXML
    private CheckBox repeatNumbers;
	
	@FXML
    private TextField sizeArray;
	
	@FXML
    private TextArea textArea;
	
	@FXML
	public void organizeChoiceBox() {
		sortChoice.setPromptText("Ordenamiento");
		sortChoice.getItems().add("Creciente");
		sortChoice.getItems().add("Decreciente");
		sortChoice.getItems().add("Aleatorio");
		sortChoice.getItems().add("Desordenados en un %");
		
		numberType.setPromptText("Tipo Numero");
		numberType.getItems().add("Enteros");
		numberType.getItems().add("De coma flotante");
	}
	
	@FXML
	void visibleChoiceBox(ActionEvent event) {
		if(manual.isSelected()) {
			sortChoice.setDisable(true);
			repeatNumbers.setDisable(true);
			repeatNumbers.setSelected(false);
		}else {
			sortChoice.setDisable(false);
			repeatNumbers.setDisable(false);
		}
    }
	
	@FXML
    void generateArray(ActionEvent event) {
		try {
			arrayCreation();
		}catch (Exception e) {
			Alert warning = new Alert(AlertType.INFORMATION);
			warning.setTitle("Error");
			warning.setHeaderText(null);
			warning.setContentText("Falta llenar alguno de los campos que se piden");
			warning.showAndWait();
		}
    }
	
	public void arrayCreation() {
		
		boolean isInteger = numberType.getValue().equals("Enteros")? true:false;
		boolean repeatNumber = repeatNumbers.isSelected() ? true:false;
		boolean random = manual.isSelected() ? false: true;
		int size = Integer.valueOf(sizeArray.getText());
		
		if (manual.isSelected()) {
			textArea.setText("Funciona para escribir valores de forma manual \n");
			worldModel = new Model(size, isInteger, random, repeatNumber);
			
			//worldModel.sortArray(sortChoice.getValue());
			//Cambiar de posision el choicebox del orden a la izquierda del BorderLayout y un Boton
			
		}else {
			textArea.setText("Funciona los valores Random \n");
			worldModel = new Model(size, isInteger, random, repeatNumber);
			Number[] array = worldModel.getArray();
			
			for (int i = 0; i < array.length; i++) {
				textArea.appendText(String.valueOf(array[i]) + "\n");
			}
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		organizeChoiceBox();
	}
}
