package code;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * @author: Abdel OreKan
 * Assignment 2
 * 
 * The consumer thread (we use thread to be able to start a producer and consumer a simultaneously)
 */
public class Consumer extends Thread {
		
		//The shared variable
		private Counter counter;

		public Consumer(Counter counter) {
			this.counter = counter;
		}
		
		/*
		 * This method is override from Thread class,  
		 * it runs automatically when we call the start
		 *  method on a Consumer instance
		 */
		@Override
		public void run() {	
			int sum=0;
			for(int i=0; i<=4; i++) {
				int sleepTime = Test.getRandomNumber(1, 3);
				sleepTime = sleepTime*1000;
				
				//wait a moment before writing 
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				//Sum the shared value
				sum+= this.counter.getCount_value();
			}
			
			this.writeInFile(sum);
		}
				
			/**
			 * this method will write a given value into a file named sum_result
			 * @param value, the sum value
			 */
			private void writeInFile(int value) {
				try (FileWriter f = new FileWriter("sum_result.txt", true); 
						BufferedWriter b = new BufferedWriter(f); 
						PrintWriter p = new PrintWriter(b);) {
							
						// Writing into the value at the end of the file
						p.println("The sum is "+String.valueOf(value)); 
						System.out.println("File is created successfully with the content : "+value);
				} catch (IOException e) 
				{ 
					System.out.println(e.getMessage());
				}

			}
}
