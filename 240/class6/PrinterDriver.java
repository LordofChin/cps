public class Printer
{	
	private static Printer printer;
	private Printer()
	{
		System.out.println("Printer Initialized");
	}	
	
	void print(String document)
	{
		System.out.println(document + " is printing");
	}
	public static Printer getInstance()
	{
		if(printer == null) printer = new Printer();
		return printer;
	}
}

public class PrinterDriver
{
	public static void main(String [] args)
	{
		//Printer p1 = new Printer() // cannot build this because the constructor is private
		Printer p1 = Printer.getInstance();	
		p1.print("homework");
		Printer p2 = Printer.getInstance(); // printer initialized only once
		p2.print("lecture");
	}
}