class ThreadingDriver
{
	public static void main(String [] args)
	{
		Runnable task1 = new DownloadThread();

		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
			print();
			}	
		});
		
		System.out.println("Thread 1 is in state: " + t1.getState());
		t1.start();
		System.out.println("Thread 1 is in state: " + t1.getState());
		t2.start();

	}	
	public static void print()
	{	
		int time = 0;
		while(time++ < 12)
		{	
			try {
				Thread.sleep(990);
				System.out.print(time + "\t");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}
}

class DownloadThread implements Runnable
{	
	public void run()
	{
		downloadFile();
	}
	public void downloadFile()
	{
		System.out.println("Starting file download... ");
		try{
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Done downloading file...");
	}
}



