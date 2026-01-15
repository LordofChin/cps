import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReaderImplementation 
{
    public static void main(String [] args)
        {
            try
            {
                FileReader fileReader = null;
                try
                {
                    fileReader = new FileReader("sample.txt");
                    BufferedReader reader = new BufferedReader(fileReader);
                    String line;

                    while ((line = reader.readLine()) != null)
                    {
                        System.out.println(line);
                    }
                }
                catch (FileNotFoundException e)
                    {
                        e.printStackTrace();
                    }
                }
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }

}