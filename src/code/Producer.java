package code;

/*
 * @author: Abdel OreKan
 * Operating Systems Assignment #3
 * 
 * The producer thread (we use thread to be able to start a producer and a simultaneously)
 */
public class Producer extends Thread {
		
	//The shared variable
	private Coordinator coordinate;
	private int[] array;
	private int index = 0;

	public Producer(Coordinator coordinate,int[] array) {
		this.coordinate = coordinate;
		this.array = array;
	}
	
	//This method is override from Thread class,  it runs automatically when we call the start method on a Producer instance
	@Override
	public void run() {	
		for(int i=0; i<=99; i++) {
			int sleepTime = Test.getRandomNumber(1, 4);
			sleepTime = sleepTime*1000;
			
			//wait a moment before writing 
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//write the index into the array
			this.writeIndex(i);
		}
		
		//write a -1 to indicate to the consumer that it has completed
		this.writeIndex(-1);	
	}
	
	/**
	 * This method will try to write an index of loop count into the shared array
	 * if there
	 * @param i
	 */
	private void writeIndex(int i) {
		//write the loop count into the shared array
		index = index%5;
		while(this.coordinate.getTotalProduced()-this.coordinate.getTotalConsume() == 5) {
			//the consumer has not read this coordinate yet, and the array is full so the producer will wait for one second and check again 
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		
		//insert into the array and updates the last placing index coordinate
		this.array[index] = i;
		this.coordinate.setTotalProduced(this.coordinate.getTotalProduced()+1);
		index++;
	}
	
}
