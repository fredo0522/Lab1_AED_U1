package com.Lab1AED.model;

import java.util.Random;

public class Model {
	
	public final String COUNTING_SORT = "Counting sort";
	public final String QUICKSORT = "Quicksort";
	public final String MERGE_SORG = "Merge sort";
	public final String ASCENDANT = "Ascendant";
	public final String DESCENDANT = "Descendant";
	public final String DISORDER = "Disorder";
	
	private Number[] arrayNumbers;
	private boolean isInteger;
	private boolean repeatNumber;
	private boolean random;
	private Number min;
	private Number max;
	
	public Model(int sizeArray, boolean isInteger, boolean random, boolean repeatNumber, int min, int max) throws GenerationException{
		this.isInteger = isInteger;
		this.repeatNumber = repeatNumber;
		this.random = random;
		this.min = min;
		this.max = max;
		arrayNumbers = new Number[sizeArray];
		try {
			createArray();
		}catch(GenerationException e) {
			throw e;
		}
		
		
	}
	
	public Model(int sizeArray, boolean isInteger, boolean random, boolean repeatNumber) throws GenerationException {
		this.isInteger = isInteger;
		this.repeatNumber = repeatNumber;
		this.random = random;
		arrayNumbers = new Number[sizeArray];
		try {
			createArray();
		}catch(GenerationException e){
			throw e;
		}
		
	}
	
	public Model(int sizeArray) {
		arrayNumbers = new Number[sizeArray];
	}
	
	public void createArray() throws GenerationException {
		if(repeatNumber) {
			createRandomNumbers();
		}else {
			try {
				createNoRepeatingRandomNumbers();
			}catch(GenerationException e) {
				throw e;
			}
			
		}
		
	}
	
	public void createRandomNumbers(){
		if(!isInteger) {
			for(int i = 0; i < arrayNumbers.length; i++) {
				arrayNumbers[i] = (float) Math.random() * Float.MAX_VALUE;
			}
		}else {
			for(int i = 0; i < arrayNumbers.length; i++) {
				Random r = new Random();
				arrayNumbers[i] = r.nextInt((max.intValue()-min.intValue())+1) + min.intValue();
				
			}
		}
	}
	
	public void createNoRepeatingRandomNumbers() throws GenerationException {
		if(!isInteger) {
			for(int i = 0; i < arrayNumbers.length; i++) {
				float randomFloat = (float) Math.random() * Float.MAX_VALUE;
				
				arrayNumbers[i] = randomFloat;
			}
		}else {
			for(int i = 0; i < arrayNumbers.length; i++) {
				if(arrayNumbers.length <= Math.abs(max.intValue()-min.intValue())) {
					Random r = new Random();
					int randomInt = r.nextInt(max.intValue()-min.intValue()+1)+ min.intValue();
					while(isRepeated(randomInt)) {
						randomInt = r.nextInt(max.intValue()-min.intValue()+1)+ min.intValue();
					}
					arrayNumbers[i] = randomInt;
				}else {
					GenerationException e = new GenerationException();
					throw e;
				}
				
			}
		}
	}
	
	public boolean isRepeated(Number number) {
		boolean repeated = false;
		
		for(int i = 0; i < arrayNumbers.length && arrayNumbers[i] != null && !repeated; i++ ) {
			if(!isInteger) {
				if(number.floatValue() == arrayNumbers[i].floatValue());{
					repeated = true;
				}
			}else {
				if(number.intValue() == arrayNumbers[i].intValue()) {
					repeated = true;
				}
			}
			
			
		}
		return repeated;
	}
	
	public void sortArray(String sortMethod, String sortChoice) {
		if(sortMethod.equals(COUNTING_SORT)) {
			countingSort(sortChoice);
		}else if(sortMethod.equals(QUICKSORT)) {
			quickSort(sortChoice);
		}
	}
	
	public void quickSort(String sortChoice) {
		if(sortChoice.equals(ASCENDANT)) {
			ascendantQuickSort(0,arrayNumbers.length -1);
		}
	}
	
	public int partitionQuickSort(int high, int low) {
		 int pivot = arrayNumbers[high].intValue(); 
	        int i = (low-1); // index of smaller element
	        for (int j=low; j<high; j++)
	        {
	            // If current element is smaller than or
	            // equal to pivot
	            if (arrayNumbers[j].intValue() <= pivot)
	            {
	                i++;
	 
	                // swap arr[i] and arr[j]
	                int temp = arrayNumbers[i].intValue();
	                arrayNumbers[i] = arrayNumbers[j];
	                arrayNumbers[j] = temp;
	            }
	        }
	 
	        // swap arr[i+1] and arr[high] (or pivot)
	        int temp = arrayNumbers[i+1].intValue();
	        arrayNumbers[i+1] = arrayNumbers[high];
	        arrayNumbers[high] = temp;
	 
	        return i+1;
	}
	
	public void ascendantQuickSort(int high, int low) {
		if (low < high)
        {
            /* pi is partitioning index, arr[pi] is 
              now at right place */
            int pi = partitionQuickSort(low, high);
 
            // Recursively sort elements before
            // partition and after partition
            ascendantQuickSort(low, pi-1);
            ascendantQuickSort(pi+1, high);
        }
	}
	
	public void countingSort(String sortChoice) {
		if(sortChoice.equals(ASCENDANT)) {
			ascendantCountingSort();
		}
		
	}
	
	public void ascendantCountingSort() {
	    Number[] aux = new Number[arrayNumbers.length];
	 
	   
	    int min = arrayNumbers[0].intValue();
	    int max = arrayNumbers[0].intValue();
	    for (int i = 1; i < arrayNumbers.length; i++) {
	      if (arrayNumbers[i].intValue() < min) {
	        min = arrayNumbers[i].intValue();
	      } else if (arrayNumbers[i].intValue() > max) {
	        max = arrayNumbers[i].intValue();
	      }
	    }
	 
	    int[] counts = new int[max - min + 1];
	 

	    for (int i = 0;  i < arrayNumbers.length; i++) {
	      counts[arrayNumbers[i].intValue() - min]++;
	    }
	 
	    counts[0]--;
	    for (int i = 1; i < counts.length; i++) {
	      counts[i] = counts[i] + counts[i-1];
	    }
	 
	    for (int i = arrayNumbers.length - 1; i >= 0; i--) {
	        aux[counts[arrayNumbers[i].intValue() - min]--] = arrayNumbers[i].intValue();
	    }
	 
	    	arrayNumbers = aux;;
	}
	
	public Number[] getArray() {
		return arrayNumbers;
	}
	
	public void setArray(Number[] array) {
		this.arrayNumbers = array;
	}
	
	public void countingSort() {
		
	}
}
