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
			numbers[i] = (float) Math.random() * Float.MAX_VALUE;
		}
	}
	
	public float[] getArray() {
		return this.numbers;
	}
	
	public static void main(String[] args) {
		Sort n = new Sort(10);
		n.createNumbers();
		
		float[] exp = n.getArray();
		for (int i = 0; i < exp.length; i++) {
			System.out.println(exp[i]);
		}
	}
}
