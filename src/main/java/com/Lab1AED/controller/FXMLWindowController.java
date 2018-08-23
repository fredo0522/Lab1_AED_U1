package com.Lab1AED.controller;

import java.net.URL;
import java.util.Optional;
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
import javafx.scene.control.TextInputDialog;

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
		sortChoice.setPromptText("Sorting");
		sortChoice.getItems().add("Ascendant");
		sortChoice.getItems().add("Descendant");
		sortChoice.getItems().add("Random");
		sortChoice.getItems().add("Disorder");
		
		sortAlgorithm.setPromptText("Algorithm");
		sortAlgorithm.getItems().add("Merge sort");
		sortAlgorithm.getItems().add("Quicksort");
		
		
		numberType.setPromptText("Number type");
		numberType.getItems().add("Integer");
		numberType.getItems().add("Float");
		
		minNumber.setDisable(true);
		maxNumber.setDisable(true);
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
    void setSortChoices(ActionEvent event) {
    	/*if(sortAlgorithm.getValue().equals("Counting sort")) {
    		sortChoice.getItems().remove(3);
    		sortChoice.getItems().remove(2);
    	}else {
    		if(sortChoice.getItems().get(2) == null && sortChoice.getItems().get(3) == null) {
    			sortChoice.getItems().add("Random");
    			sortChoice.getItems().add("Disorder");
    		}
    	}*/
    }
	
	@FXML
	void changeMinMax(ActionEvent event) {
		if(numberType.getValue().equals("Integer")) {
			if(manual.isSelected()) {
				maxNumber.setDisable(true);
				maxNumber.setText("");
				minNumber.setDisable(true);
				minNumber.setText("");
			}else {
				minNumber.setDisable(false);
				maxNumber.setDisable(false);
			}
			if(sortAlgorithm.getItems().size() < 3) {
				sortAlgorithm.getItems().add("Counting sort");
			}
			
		}else {
			minNumber.setDisable(true);
			minNumber.setText("");
			maxNumber.setDisable(true);
			maxNumber.setText("");
			if(sortAlgorithm.getItems().size() > 2) {
				sortAlgorithm.getItems().remove(2);
			}
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
			warning.setContentText("Information missing to execute the task");
			warning.showAndWait();
		}
    }
	
	public void arrayCreation() throws GenerationException {
		textArea.setText("");
		boolean isInteger = numberType.getValue().equals("Integer")? true:false;
		boolean repeatNumber = repeatNumbers.isSelected() ? true:false;
		boolean random = manual.isSelected() ? false: true;
		int size = Integer.valueOf(sizeArray.getText());
		
		if (manual.isSelected()) {
			
			worldModel = new Model(size);
			
			if(isInteger) {
				Number[] numbers = new Number[size];
				for(int j = 0 ; j < numbers.length; j++) {
					TextInputDialog dialog = new TextInputDialog();
					dialog.setTitle("Entrada Posicion: " + String.valueOf(j));
					dialog.setHeaderText(null);
					dialog.setContentText("Escriba la entrada en la posicion " + String.valueOf(j) + " del arreglo");
					Optional<String> result = dialog.showAndWait();
					int number = result.isPresent() ? Integer.valueOf(result.get()): 0;
					numbers[j] = number;
				}
				worldModel.setArray(numbers);
			}else {
				
			}
			
		}else {
			if(isInteger) {

				try {
					worldModel = new Model(size, isInteger, random, repeatNumber,Integer.valueOf(minNumber.getText()) , Integer.valueOf(maxNumber.getText()));
				}catch(GenerationException e) {
					throw e;
				}
				
				worldModel = new Model(size, isInteger, random, repeatNumber,Integer.valueOf(minNumber.getText()) , Integer.valueOf(maxNumber.getText()));

			}else {
				try {
					worldModel = new Model(size, isInteger, random, repeatNumber);
				}catch(GenerationException e) {
					throw e;
				}
				
			}
		}
		
		Number[] array = worldModel.getArray();
		textArea.setText("");
		for (int i = 0; i < array.length; i++) {
			textArea.appendText(String.valueOf(array[i]) + "\n");
		}
	}
	
	@FXML
    void sortArray(ActionEvent event) {
		if(sortAlgorithm.getValue() != null && sortChoice.getValue() != null) {
			worldModel.sortArray(sortAlgorithm.getValue(), sortChoice.getValue());
		}
		
		textArea.setText("");
		Number[] array = worldModel.getArray();
		for (int i = 0; i < array.length; i++) {
			textArea.appendText(String.valueOf(array[i]) + "\n");
		}
		
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		organizeBoxes();
		sortChoice.setVisible(false);
		sortAlgorithm.setVisible(false);
		btnSort.setVisible(false);
	}
}
