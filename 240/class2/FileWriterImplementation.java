import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class FileWriterImplementation
{
    public static void main(String [] args)
    {
        FileWriter fileWriter = null;
        try
        {
            fileWriter = new FileWriter("sampleOutput.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write("ZIP CODE: 48859");
            System.out.println("Written to the file");
            writer.close();
            fileWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}