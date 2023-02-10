package code;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * @author: Abdel OreKan
 * Operating Systems Assignment #3
 * 
 * The consumer thread (we use thread to be able to start a producer and consumer a simultaneously)
 */
public class Consumer extends Thread {
		
		//The shared variable
		private Coordinator coordinate;
		private int[] array;
		private int index = 0;
	
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
			writeInFile("======= NEW EXECUTION ============");
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
					
					while(this.coordinate.getTotalProduced()-this.coordinate.getTotalConsume()==0) {
						//there is nothing to read, the consumer will wait for one second and check again
						try {
							writeInFile("Consumer waiting");
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					index = index%5;
					if(this.array[index]!=-1) {
						//write the value into the output file
						writeInFile(""+this.array[index]);
						this.coordinate.setTotalConsume(this.coordinate.getTotalConsume()+1);
						index++;
					}else {
						//The consumer attempt the end of the array
						writeInFile("Consumer Done");
						done =true;
					}
			}
			
		}
				
			/**
			 * this method will write a given value into a file named sum_result
			 * @param value, the sum value
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
