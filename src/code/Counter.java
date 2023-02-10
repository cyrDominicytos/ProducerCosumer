package code;


public class Counter {
	//The shared variable
	private int count_value;

	public Counter(int count_value) {
		this.count_value = count_value;
	}

	public int getCount_value() {
		return count_value;
	}

	public void setCount_value(int count_value) {
		this.count_value = count_value;
	}
}
