import java.io.*;

class ThreadingDriver
{	
	public static volatile int progress;
	public static void main(String [] args) throws InterruptedException
	{
		Thread t1 = new Thread(ThreadingDriver::readFile);
		Thread t2 = new Thread(ThreadingDriver::writeFile);
		
		t1.setDaemon(true);
		t2.setDaemon(true);
		System.out.println("Thread 1 is in state: " + t1.getState());
		t1.start();
		System.out.println("Thread 1 is in state: " + t1.getState());
		t2.start();


		//t1.join();
		//t2.join();
		
		Thread.sleep(10000);
		System.out.println("Rest of code....");
	}	

	public static void print()
	{
		int lastPrinted = 0;
		while(progress < 99)
		{	
			try {	

				Thread.sleep(100);
				if (lastPrinted != progress) {
					System.out.print(progress + "\t");
					lastPrinted = progress;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}
	public static void downloadFile()
	{
		System.out.println("Starting file download... ");
		try{
			for (progress = 1; progress < 100; progress++) 
			{
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Done downloading file...");
	}

	public static void readFile()
	{
		BufferedReader reader = null;
		
		try{
			reader = new BufferedReader(new FileReader("input.txt"));
			String line;
			while((line=reader.readLine()) !=null)
			{
				System.out.println("Read Line: " + line);
				Thread.sleep(500);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} catch(InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void writeFile() 
	{
		BufferedWriter writer = null;
		try {
			Thread.sleep(200);
			writer = new BufferedWriter(new FileWriter("input.txt"));
			for(int i =0; i<5;i++) 
			{
				String data = "Line " + i;
				writer.write(data);
				writer.newLine();
				System.out.println("Written: " + data);
				Thread.sleep(1000);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

