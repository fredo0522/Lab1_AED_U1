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
    private ComboBox<String> sortAlgorithm;
	
	@FXML
	private ComboBox<String> numberType;
	
	@FXML
	private Button btnAction;
	
	@FXML
    private Button btnSort;
	
	@FXML
    private CheckBox manual;
	
	@FXML
    private CheckBox repeatNumbers;
	
	@FXML
    private TextField sizeArray;
	
    @FXML
    private TextField minNumber;
	
	@FXML
    private TextField maxNumber;
	
	@FXML
    private TextArea textArea;
	
	@FXML
	public void organizeBoxes() {
		sortChoice.setPromptText("Ordenamiento");
		sortChoice.getItems().add("Creciente");
		sortChoice.getItems().add("Decreciente");
		sortChoice.getItems().add("Aleatorio");
		sortChoice.getItems().add("Desordenados en un %");
		
		sortAlgorithm.setPromptText("Algoritmo");
		sortAlgorithm.getItems().add("Merge sort");
		sortAlgorithm.getItems().add("Quicksort");
		sortAlgorithm.getItems().add("Counting sort");
		
		numberType.setPromptText("Tipo Numero");
		numberType.getItems().add("Enteros");
		numberType.getItems().add("De coma flotante");
	}
	
	@FXML
	void visibleChoiceBox(ActionEvent event) {
		if(manual.isSelected()) {
			repeatNumbers.setDisable(true);
			repeatNumbers.setSelected(false);
			maxNumber.setDisable(true);
			maxNumber.setText("");
			minNumber.setDisable(true);
			minNumber.setText("");
		}else {
			repeatNumbers.setDisable(false);
			maxNumber.setDisable(false);
			minNumber.setDisable(false);
		}
    }
	@FXML
	void changeMinMax(ActionEvent event) {
		if(numberType.getValue().equals("Enteros")) {
			minNumber.setDisable(false);
			maxNumber.setDisable(false);
			sortAlgorithm.getItems().add("Counting sort");
		}else {
			minNumber.setDisable(true);
			maxNumber.setDisable(true);
			sortAlgorithm.getItems().remove(2);
		}
	}
	
	@FXML
    void generateArray(ActionEvent event) {
		try {
			
			arrayCreation();
			sortChoice.setVisible(true);
			sortAlgorithm.setVisible(true);
			btnSort.setVisible(true);
			
		}catch(GenerationException ex) {
			Alert warning = new Alert(AlertType.INFORMATION);
			warning.setTitle("Error");
			warning.setHeaderText(null);
			warning.setContentText(ex.getMessage());
			warning.showAndWait();
			
		
		}catch (Exception e) {
			e.printStackTrace();
			Alert warning = new Alert(AlertType.INFORMATION);
			warning.setTitle("Error");
			warning.setHeaderText(null);
			warning.setContentText("Falta llenar alguno de los campos que se piden");
			warning.showAndWait();
		}
    }
	
	public void arrayCreation() throws GenerationException {
		textArea.setText("");
		boolean isInteger = numberType.getValue().equals("Enteros")? true:false;
		boolean repeatNumber = repeatNumbers.isSelected() ? true:false;
		boolean random = manual.isSelected() ? false: true;
		int size = Integer.valueOf(sizeArray.getText());
		
		if (manual.isSelected()) {
			textArea.setText("Funciona para escribir valores de forma manual \n");
			worldModel = new Model(size);
			
		}else {
			if(isInteger) {
				try {
					worldModel = new Model(size, isInteger, random, repeatNumber,Integer.valueOf(minNumber.getText()) , Integer.valueOf(maxNumber.getText()));
				}catch(GenerationException e) {
					throw e;
				}
				
			}else {
				try {
					worldModel = new Model(size, isInteger, random, repeatNumber);
				}catch(GenerationException e) {
					throw e;
				}
				
			}
			
			Number[] array = worldModel.getArray();
			
			for (int i = 0; i < array.length; i++) {
				textArea.appendText(String.valueOf(array[i]) + "\n");
			}
		}
	}
	
	@FXML
    void sortArray(ActionEvent event) {
		
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		organizeBoxes();
		sortChoice.setVisible(false);
		sortAlgorithm.setVisible(false);
		btnSort.setVisible(false);
	}
}
