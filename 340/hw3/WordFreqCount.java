import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFreqCount
{
    private TreeMap<String, Integer> freqyTable;
    private List <Map.Entry<String, Integer>> sortedFreqyTable;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Specify file path: ");
        String filePath = sc.nextLine();
        sc.close();

        WordFreqCount wfc = new WordFreqCount(filePath);

        //wfc.printFreqyTable();
        System.out.println("Top 20 Least Appeared Words: ");
        wfc.printLowerFreqyTable(20);

        System.out.println("Top 20 Most Appeared Words: ");
        wfc.printHigherFreqyTable(20);

    }

    public WordFreqCount(String filePath)
    {
        setFreqyTable(filePath);
        sortedFreqyTable = sortByValue(this.freqyTable);
    }
    public WordFreqCount(){}

    public void printFreqyTable()
    {
        System.out.println("Word Frequencies:");
        for (Map.Entry<String, Integer> entry : this.freqyTable.entrySet()) 
        {
            System.out.printf("%-15s: %d%n", entry.getKey(), entry.getValue());
        }
    }

    public void setFreqyTable(String filePath)
    {
        try 
        {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] words = line.split("\\W+");
                for (String word : words) 
                {
                    if (word.isEmpty()) continue;
                    word = word.toLowerCase();
                    this.freqyTable.put(word, this.freqyTable.getOrDefault(word, 0) + 1);
                }
            }
            reader.close();
            
            
        } 
        catch (Exception e) 
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static List <Map.Entry<String, Integer>> sortByValue(Map<String, Integer> map) 
    {
        List<Map.Entry<String, Integer>> list = new java.util.ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() 
        {
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) 
            {
                return e2.getValue().compareTo(e1.getValue());
            }
        });
        return list;
    }

    public void printLowerFreqyTable(int threshold)
    {
        for (Map.Entry<String, Integer> entry : this.freqyTable.entrySet()) 
        {
            if (entry.getValue() < threshold) {
                System.out.printf("%-15s: %d%n", entry.getKey(), entry.getValue());
            }
        }
    }
    
    public void printHigherFreqyTable(int threshold)
    {
        for (Map.Entry<String, Integer> entry : this.freqyTable.entrySet()) 
        {
            if (entry.getValue() > threshold) {
                System.out.printf("%-15s: %d%n", entry.getKey(), entry.getValue());
            }
        }
    }
}