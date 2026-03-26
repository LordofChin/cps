public class BankingSystem
{	

	public static int balance = 1000;

	public static void main(String [] args)
	{
		System.out.println("Initial Balance: $" + balance);
		Thread t1 = new DepositThread();
		Thread t2 = new WithdrawThread();
	
		t1.run();
		try{
			t1.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		t2.run();
		
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nFinal Balance: $" + balance);
		
	}
	
	public static void withdraw(int amount) 
	{
		System.out.printf("Widthdrawing $%d...\n", amount);	
		balance -= amount;
	}
	
	public static void deposit(int amount) 
	{
		System.out.printf("Depositing $%d...\n", amount);	
		balance += amount;
	}

	static class DepositThread extends Thread
	{
		@Override
		public void run()
		{	
			deposit(500);
			System.out.println("Balance after deposit: $" + balance);
		}
	}

	static class WithdrawThread extends Thread
	{
		@Override
		public void run()
		{
			withdraw(200);
			System.out.println("Balance after withdrawing: $" + balance);
		}
	}
}


