package code;

/*
 * @author: Abdel OreKan
 * Operating Systems Assignment #3
 * The class to test the system
 */
public class Test {

	public static void main(String[] args) {
	
		//Counter, the shared variable init to 100
		int[] sharedArray = new int[5];
		Coordinator c = new Coordinator();
		Producer producer = new Producer(c, sharedArray);
		Consumer consumer = new Consumer(c, sharedArray);
		
		//Run producer and consumer
		producer.start();
		consumer.start();
	}
	
	/**
	 * Generate a random number between min and max
	 * @param min
	 * @param max
	 * @return the random number
	 */
	public static int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}

}
