package com.Lab1AED.model;

import java.util.Random;

public class Model {
	
	public final String COUNTING_SORT = "Counting sort";
	public final String QUICKSORT = "Quicksort";
	public final String MERGE_SORT = "Merge sort";
	public final String ASCENDANT = "Ascendant";
	public final String DESCENDANT = "Descendant";
	public final String DISORDER = "Disorder with a %";
	
	private Number[] arrayNumbers;
	private long timeAlgorithm;
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
	
	public void sortArray(String sortMethod) {
		long startTimer = System.currentTimeMillis();
		
		if(sortMethod.equals(COUNTING_SORT)) {
			countingSort();
		}else if(sortMethod.equals(QUICKSORT)) {
			quickSort();
		}else if(sortMethod.equals(MERGE_SORT)) {
			mergeSort();
		}
		long endTimer = System.currentTimeMillis();
		this.timeAlgorithm = endTimer - startTimer;
	}
	
	public void mergeSort() {
		ascendantMergeSort(0, arrayNumbers.length-1);
	}
	
	public void ascendantMerge(int l, int m, int r) {
		if(!isInteger) {

	        int n1 = m - l + 1; 
	        int n2 = r - m; 
	        float L[] = new float [n1]; 
	        float R[] = new float [n2]; 
	        for (int i=0; i<n1; ++i) 
	            L[i] = arrayNumbers[l + i].floatValue(); 
	        for (int j=0; j<n2; ++j) 
	            R[j] = arrayNumbers[m + 1+ j].floatValue(); 

	        int i = 0, j = 0; 
	        int k = l; 
	        while (i < n1 && j < n2) { 
	            if (L[i] <= R[j]) 
	            { 
	                arrayNumbers[k] = L[i]; 
	                i++; 
	            } 
	            else
	            { 
	                arrayNumbers[k] = R[j]; 
	                j++; 
	            } 
	            k++; 
	        }
	        while (i < n1){ 
	            arrayNumbers[k] = L[i]; 
	            i++; 
	            k++; 
	        } 
	        while (j < n2){ 
	            arrayNumbers[k] = R[j]; 
	            j++; 
	            k++; 
	        }
		}else {

	        int n1 = m - l + 1; 
	        int n2 = r - m; 
	        int L[] = new int [n1]; 
	        int R[] = new int [n2]; 
	        for (int i=0; i<n1; ++i) 
	            L[i] = arrayNumbers[l + i].intValue(); 
	        for (int j=0; j<n2; ++j) 
	            R[j] = arrayNumbers[m + 1+ j].intValue(); 

	        int i = 0, j = 0; 
	        int k = l; 
	        while (i < n1 && j < n2) { 
	            if (L[i] <= R[j]) 
	            { 
	                arrayNumbers[k] = L[i]; 
	                i++; 
	            } 
	            else
	            { 
	                arrayNumbers[k] = R[j]; 
	                j++; 
	            } 
	            k++; 
	        }
	        while (i < n1){ 
	            arrayNumbers[k] = L[i]; 
	            i++; 
	            k++; 
	        } 
	        while (j < n2){ 
	            arrayNumbers[k] = R[j]; 
	            j++; 
	            k++; 
	        }
		}
		 
	}
	
	public void ascendantMergeSort(int l, int r) {
		if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            ascendantMergeSort(l, m); 
            ascendantMergeSort( m+1, r); 
  
            // Merge the sorted halves 
            ascendantMerge(l, m, r); 
        } 
	}
	
	public void quickSort() {
		ascendantQuickSort(0,arrayNumbers.length -1);
	}
	
	public int partitionQuickSort(int low, int high) {
		if(!isInteger) {
			float pivot = arrayNumbers[high].floatValue(); 
	        int i = (low-1);
	        for (int j=low; j<high; j++){
	            if (arrayNumbers[j].floatValue() <= pivot){
	                i++;
	                float temp = arrayNumbers[i].floatValue();
	                arrayNumbers[i] = arrayNumbers[j];
	                arrayNumbers[j] = temp;
	            }
	        }
	        float temp = arrayNumbers[i+1].floatValue();
	        arrayNumbers[i+1] = arrayNumbers[high];
	        arrayNumbers[high] = temp;
	 
	        return i+1;	
		}else {
			int pivot = arrayNumbers[high].intValue(); 
	        int i = (low-1); // index of smaller element
	        for (int j=low; j<high; j++){
	            if (arrayNumbers[j].intValue() <= pivot){
	                i++;
	                int temp = arrayNumbers[i].intValue();
	                arrayNumbers[i] = arrayNumbers[j];
	                arrayNumbers[j] = temp;
	            }
	        }
	        int temp = arrayNumbers[i+1].intValue();
	        arrayNumbers[i+1] = arrayNumbers[high];
	        arrayNumbers[high] = temp;
	 
	        return i+1;	
		}
		 
	}
	
	public void ascendantQuickSort(int low, int high) {
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
	
	public void countingSort() {
		ascendantCountingSort();
		
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
	
	public long getTimeAlgorithm() {
		return timeAlgorithm;
	}
}
