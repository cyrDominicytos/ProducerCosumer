package code;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * @author: Abdel OreKan
 * Operating Systems Assignment #3
 * @date: 2023-02-09
 * 
 * The consumer thread (we use thread to be able to start a producer and consumer a simultaneously)
 */
public class Consumer extends Thread {
		
		//The shared variable
		private Coordinator coordinate;
		private int[] array;
	
		public Consumer(Coordinator coordinate,int[] array) {
			this.coordinate = coordinate;
			this.array = array;
		}
		
		/*
		 * This method is override from Thread class,  
		 * it runs automatically when we call the start
		 *  method on a Consumer instance
		 */
		@Override
		public void run() {	
			writeInFile("\n======= NEW EXECUTION ============");
			boolean done=false;
			
			while(!done) {
					int sleepTime = Test.getRandomNumber(2, 5);
					sleepTime = sleepTime*1000;
					
					//the consumer waits a moment before reading 
					try {
						Thread.sleep(sleepTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					//Retrieve the index of the next item that the consumer will read (this will be in the range of 0 - 4) 
					int index = (this.coordinate.getLastRemovalIndex()+1)%5;
					while(!this.coordinate.getArrayIndexStatus()[index]) {
						//there is nothing to read, the consumer will wait for one second and check again
						try {
							writeInFile("Consumer waiting");
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					
					if(this.array[index]!=-1) {
						//write the value into the output file
						writeInFile(""+this.array[index]);
						this.coordinate.setArrayIndexStatus(index, false);
						this.coordinate.setLastRemovalIndex(index);
					}else {
						//The consumer attempt the end of the array
						writeInFile("Consumer Done");
						done=true;
					}
			}
			
		}
				
			/**
			 * this method will write a given value into a file named sum_result
			 * @param value, the text to write into the file
			 */
			private void writeInFile(String value) {
				try (FileWriter f = new FileWriter("result.txt", true); 
						BufferedWriter b = new BufferedWriter(f); 
						PrintWriter p = new PrintWriter(b);) {
							
						// Writing into the value at the end of the file
						p.println(value); 
						System.out.println("File is created successfully with the content : "+value);
				} catch (IOException e) 
				{ 
					System.out.println(e.getMessage());
				}

			}
}
