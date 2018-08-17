package model;

public class Sort {
	float[] numbers;
	
	public Sort(int n) {
		numbers = new float[n];
	}
	
	public void  sortArrayIncrase(float[] n) {
		
	}
	
	public void sortArrayDecrease(float[] n) {
		
	}
	
	public void createNumbers() {
		for (int i = 0; i < numbers.length; i++){
			double chance = Math.random();
			System.out.println(chance + " Chance");
			if(chance >= 0.5) {
				numbers[i] = (float) Math.random() * Float.MAX_VALUE;
			}else {
				numbers[i] = (float) Math.floor((double) Math.random() * Double.MAX_VALUE);
			}
			
		}
	}
	
	public float[] getArray() {
		return this.numbers;
	}
	
	public static void main(String[] args) {
		Sort a = new Sort(10);
		a.createNumbers();
		float[] prep = a.getArray();
		
		for (int i = 0; i < prep.length; i++) {
			System.out.println(prep[i]);
		}
	}
	
}
