package com.Lab1AED.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import com.Lab1AED.model.GenerationException;
import com.Lab1AED.model.Model;

class SortTest {
	
	private Model worldModel;
	private Number[] numbers;
	
	public void setupCountingSort() {
		Random r = new Random();
		numbers = new Number[100];
		for(int i = 0; i < numbers.length ; i++) {
			numbers[i] = r.nextInt(Integer.MAX_VALUE);
		}
		try {
			worldModel = new Model(1, true, true, true, 0, 10);
			worldModel.setArray(numbers);
		}catch(GenerationException e) {
			
		}
	}
	
	public void setup1() {
		Random r = new Random();
		numbers = new Number[1000000];
		for(int i = 0; i < numbers.length ; i++) {
			numbers[i] = r.nextInt(Integer.MAX_VALUE);
		}
		try {
			worldModel = new Model(1, true, true, true, 0, 10);
			worldModel.setArray(numbers);
		}catch(GenerationException e) {
			
		}	
	}
	
	public void setup2() {
		numbers = new Number[10000];
		for(int i=0; i < numbers.length; i++) {
			numbers[i] = i;
		}
		
		try {
			worldModel = new Model(numbers.length, true, true, true, 0, 10000000);
			worldModel.setArray(numbers);
		}catch(GenerationException e) {
			
		}	
	}
	
	public void setup3() {
		Random r = new Random();
		numbers = new Number[10000];
		
		for(int i = 0; i < numbers.length; i++) {
			if(i <= numbers.length/2) {
				numbers[i] = i;
			}else {
				numbers[i] = r.nextInt(100);
			}
		}
		
		try {
			worldModel = new Model(1, true, true, true, 0, 10);
			worldModel.setArray(numbers);
		} catch (GenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	@Test
	public void quickSortTest() {
		setup1();
		worldModel.quickSort();
		boolean sorted = true;
		int min = numbers[0].intValue();
		int max = numbers[2].intValue();
		for(int i = 1; i < numbers.length -3 && sorted; i++) {
			if(min > numbers[i].intValue() || max < numbers[i].intValue()) {
				sorted = false;
			}
			min = numbers[i].intValue();
			max = numbers[i+2].intValue();
		}
		
		assertTrue(sorted);
	}
	
	@Test
	public void quickSortWhenSortedTest() {
		setup2();
		worldModel.quickSort();
		boolean sorted = true;
		int min = numbers[0].intValue();
		int max = numbers[2].intValue();
		for(int i = 1; i < numbers.length -3 && sorted; i++) {
			if(min > numbers[i].intValue() || max < numbers[i].intValue()) {
				sorted = false;
			}
			min = numbers[i].intValue();
			max = numbers[i+2].intValue();
		}
		
		assertTrue(sorted);
	}
	
	@Test
	public void quickSortHalfArraySorted() {
		setup3();
		worldModel.quickSort();
		boolean sorted = true;
		int min = numbers[0].intValue();
		int max = numbers[2].intValue();
		for(int i = 1; i < numbers.length -3 && sorted; i++) {
			if(min > numbers[i].intValue() || max < numbers[i].intValue()) {
				sorted = false;
			}
			min = numbers[i].intValue();
			max = numbers[i+2].intValue();
		}
		
		assertTrue(sorted);
	}
	
	@Test
	public void countingSortTest() {
		setupCountingSort();
		worldModel.countingSort();
		boolean sorted = true;
		int min = numbers[0].intValue();
		int max = numbers[2].intValue();
		for(int i = 1; i < numbers.length -3 && sorted; i++) {
			if(min > numbers[i].intValue() || max < numbers[i].intValue()) {
				sorted = false;
			}
			min = numbers[i].intValue();
			max = numbers[i+2].intValue();
		}
		
		assertTrue(sorted);
	}
	
	@Test
	public void countingSortWhenSortedTest() {
		setup2();
		worldModel.countingSort();
		boolean sorted = true;
		int min = numbers[0].intValue();
		int max = numbers[2].intValue();
		for(int i = 1; i < numbers.length -3 && sorted; i++) {
			if(min > numbers[i].intValue() || max < numbers[i].intValue()) {
				sorted = false;
			}
			min = numbers[i].intValue();
			max = numbers[i+2].intValue();
		}
		
		assertTrue(sorted);
	}
	
	@Test
	public void mergeSortTest() {
		setup1();
		worldModel.mergeSort();
		boolean sorted = true;
		int min = numbers[0].intValue();
		int max = numbers[2].intValue();
		for(int i = 1; i < numbers.length -3 && sorted; i++) {
			if(min > numbers[i].intValue() || max < numbers[i].intValue()) {
				sorted = false;
			}
			min = numbers[i].intValue();
			max = numbers[i+2].intValue();
		}
		
		assertTrue(sorted);
	}

}
