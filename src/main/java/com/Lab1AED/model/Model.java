package com.Lab1AED.model;

import java.util.Random;

public class Model {
	
	private Number[] arrayNumbers;
	private boolean isInteger;
	private boolean repeatNumber;
	private boolean random;
	private Number min;
	private Number max;
	
	public Model(int sizeArray, boolean isInteger, boolean random, boolean repeatNumber, int min, int max) {
		this.isInteger = isInteger;
		this.repeatNumber = repeatNumber;
		this.random = random;
		this.min = min;
		this.max = max;
		arrayNumbers = new Number[sizeArray];
		
		if(random) createArray();
		else createArrayManual();
	}
	public Model(int sizeArray, boolean isInteger, boolean random, boolean repeatNumber, float min, float max) {
		this.isInteger = isInteger;
		this.repeatNumber = repeatNumber;
		this.random = random;
		this.min = min;
		this.max = max;
		arrayNumbers = new Number[sizeArray];
		
		if(random) createArray();
		else createArrayManual();
	}
	
	public Model(int sizeArray) {
		arrayNumbers = new Number[sizeArray];
	}
	
	public void createArray() {
		if(!isInteger) {
			for(int i = 0; i < arrayNumbers.length; i++) {
				
				max =max.floatValue() > Float.MAX_VALUE ? max = Float.MAX_VALUE : max ;
				arrayNumbers[i] = (float) Math.random() * (max.floatValue()- max.floatValue()) + (min.floatValue());
			}
		}else {
			for(int i = 0; i < arrayNumbers.length; i++) {
				//arrayNumbers[i] = (int) Math.random() * Integer.MAX_VALUE + (0);
				Random r = new Random();
				arrayNumbers[i] = r.nextInt(max.intValue()-min.intValue());
				
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
