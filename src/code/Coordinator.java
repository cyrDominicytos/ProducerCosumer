package code;
/*
 * @author: Abdel OreKan
 * Operating Systems Assignment #3
 * @date: 2023-02-10
 * 
 * This class will be a shared variable to coordinate the placing and removal of items from the circular buffer
 */
public class Coordinator {
	//The last index on which producer write
	private int lastPlacingIndex = -1;
	//The last index on which consumer read
	private int lastRemovalIndex = -1;
	//this variable help to know if we have unread data into a particular index of the circular array (false means, there is nothing to read)
	private boolean[] arrayIndexStatus =  {false, false,false,false, false}; 
	
	
	public boolean[] getArrayIndexStatus() {
		return arrayIndexStatus;
	}
	public void setArrayIndexStatus(int index, boolean status) {
		this.arrayIndexStatus[index] = status;
	}
	public int getLastPlacingIndex() {
		return lastPlacingIndex;
	}
	public void setLastPlacingIndex(int lastPlacingIndex) {
		this.lastPlacingIndex = lastPlacingIndex;
	}
	public int getLastRemovalIndex() {
		return lastRemovalIndex;
	}
	public void setLastRemovalIndex(int lastRemovalIndex) {
		this.lastRemovalIndex = lastRemovalIndex;
	}
	
	
}
