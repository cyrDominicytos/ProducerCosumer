package code;

/*
 * @author: Abdel OreKan
 * Assignment 2
 * The class to test the system
 */
public class Test {

	public static void main(String[] args) {
	
		//Counter, the shared variable init to 100
		Counter counter = new Counter(100);
		Producer producer = new Producer(counter);
		Consumer consumer = new Consumer(counter);
		
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
