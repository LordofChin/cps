import java.io.IOException;
import java.io.FileWriter;
import java.time.LocalDateTime;
import Java.time.formate.DateTimeFormatter;

public class LoggerDriver
{
	public static void main(String [] args)
	{
		Logger logger = Logger.getInstance();
		logger.log("Application Started");
		logger.log("Operations Performed");
		logger.log("Operation Closing");
	}	
}

private Logger
{
	private static Logger logger;
	private FileWriter writer;
	private Logger()
	{
		try
		{
			writer = new FileWriter("app.log", true)
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public Logger getInstance()
	{
		if (logger == null)
		{
			Logger = new Logger();	
		}
	}
	public void log(String log)
	{
		writer.print(log);
	}
}