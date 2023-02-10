package code;
/*
 * @author: Abdel OreKan
 * Assignment 2
 * 
 * This class will be a shared variable to coordinate the placing and removal of items from the circular buffer
 */
public class Coordinator {
	
	private int totalProduced = 0;
	private int totalConsume = 0;
	
	public int getTotalProduced() {
		return totalProduced;
	}
	public void setTotalProduced(int totalProduced) {
		this.totalProduced = totalProduced;
	}
	public int getTotalConsume() {
		return totalConsume;
	}
	public void setTotalConsume(int totalConsume) {
		this.totalConsume = totalConsume;
	}
}
