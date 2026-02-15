import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

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

        System.out.println("Top 20 Least Appeared Words (redundancy ordered alphabetically by TreeMap implementation): ");
        wfc.printLowerFreqyTable(20);

        System.out.println("Top 20 Most Appeared Words: ");
        wfc.printHigherFreqyTable(20);


    }

    public WordFreqCount(String filePath)
    {
        this.freqyTable = new TreeMap<>();
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
                String[] words = line.split("\\W+|\\d+"); // split by 1 or more non word symbol, or 1 or more numeric symbols. 
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

    public static List<Map.Entry<String, Integer>> sortByValue(Map<String, Integer> map) 
    {
        List<Map.Entry<String, Integer>> list = new java.util.ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
        });
        return list;
    }

    public void printLowerFreqyTable(int quant)    // quant is synonymous with stop in this method 
    {
        Map.Entry<String, Integer> entry;  
        for (int i = 0; i < quant; i++) 
        {
            entry = sortedFreqyTable.get(i);
            System.out.printf("%-15s: %d%n", entry.getKey(), entry.getValue());
        }
    }
    
    public void printHigherFreqyTable(int quant)
    {
        Map.Entry<String, Integer> entry;  
        int iLast = this.sortedFreqyTable.size() - 1;
        int stop = iLast - quant;
        for (int i = iLast; i > stop; i--) 
        {
            entry = sortedFreqyTable.get(i);
            System.out.printf("%-15s: %d%n", entry.getKey(), entry.getValue());
        }
    }


}