package com.Lab1AED.model;

import java.util.Random;

public class Model {
	
	private Number[] arrayNumbers;
	private boolean isInteger;
	private boolean repeatNumber;
	private boolean random;
	
	public Model(int sizeArray, boolean isInteger, boolean random, boolean repeatNumber) {
		this.isInteger = isInteger;
		this.repeatNumber = repeatNumber;
		this.random = random;
		arrayNumbers = new Number[sizeArray];
		
		if(random) createArray();
		else createArrayManual();
	}
	
	public void createArray() {
		if(!isInteger) {
			for(int i = 0; i < arrayNumbers.length; i++) {
				arrayNumbers[i] = (float) Math.random() * Float.MAX_VALUE + (0);
			}
		}else {
			for(int i = 0; i < arrayNumbers.length; i++) {
				//arrayNumbers[i] = (int) Math.random() * Integer.MAX_VALUE + (0);
				Random r = new Random();
				arrayNumbers[i] = r.nextInt(Integer.MAX_VALUE);
				
				System.out.println(arrayNumbers[i]);
			}
		}
		
	}
	
	public void createArrayManual() {
		System.out.println("Se creo un array Manual");
	}
	
	public void sortArray(String sortMethod) {
		
	}
	
	public Number[] getArray() {
		return arrayNumbers;
	}
	
	public void setArray(Number[] array) {
		this.arrayNumbers = array;
	}
	
}
