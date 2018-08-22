package com.Lab1AED.model;

public class Model {
	
	private float[] arrayNumbers;
	private boolean isInteger;
	private boolean repeatNumber;
	private boolean random;
	
	public Model(int sizeArray, boolean isInteger, boolean random, boolean repeatNumber) {
		this.isInteger = isInteger;
		this.repeatNumber = repeatNumber;
		this.random = random;
		arrayNumbers = new float[sizeArray];
		
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
				arrayNumbers[i] = (float) Math.random() * Integer.MAX_VALUE + (0);
			}
		}
		
	}
	
	public void createArrayManual() {
		System.out.println("Se creo un array Manual");
	}
	
	public void sortArray(String sortMethod) {
		
	}
	
	public float[] getArray() {
		return arrayNumbers;
	}
	
	public void setArray(float[] array) {
		this.arrayNumbers = array;
	}
	
}
