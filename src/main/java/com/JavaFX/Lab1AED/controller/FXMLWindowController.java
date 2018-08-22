package com.JavaFX.Lab1AED.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class FXMLWindowController implements Initializable{
	
	@FXML
	private ChoiceBox<String> sortChoice;
	
	@FXML
	private Button btnAction;
	
	@FXML
    private CheckBox manual;
	
	@FXML
    private TextField cantidadEntradas;
	
	@FXML
	public void organizeChoiceBox() {
		sortChoice.getItems().add("Ordenamiento Creciente");
		sortChoice.getItems().add("Ordenamiento Decreciente");
		sortChoice.getItems().add("Aleatorio");
		sortChoice.getItems().add("Desordenados en un %");
	}
	
	@FXML
	void visibleChoiceBox(ActionEvent event) {
		if(!manual.isDisabled()) {
			sortChoice.setDisable(true);
		}else {
			sortChoice.setDisable(false);
		}
    }
	
	@FXML
    void generateArray(ActionEvent event) {
		int cantidades = Integer.valueOf(cantidadEntradas.getText());
		for (int i = 0; i < cantidades; i++) {
			System.out.println("Funciona");
		}
    }
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		organizeChoiceBox();
	}
}
