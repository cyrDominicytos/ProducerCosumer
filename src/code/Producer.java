package code;

/*
 * @author: Abdel OreKan
 * Assignment 2
 * 
 * The producer thread (we use thread to be able to start a producer and a simultaneously)
 */
public class Producer extends Thread {
		
	//The shared variable
	private Counter counter;

	public Producer(Counter counter) {
		this.counter = counter;
	}
	
	//This method is override from Thread class,  it runs automatically when we call the start method on a Producer instance
	@Override
	public void run() {		
		for(int i=0; i<=4; i++) {
			int sleepTime = Test.getRandomNumber(1, 3);
			sleepTime = sleepTime*1000;
			
			//wait a moment before writing 
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//write the loop count into the shared variable
			this.counter.setCount_value(i);
		}
				
	}
	
}
