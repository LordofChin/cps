import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//KnapSack class data describes an array list of Items objects and has weight and size constraints.
public class KnapSack 
{
    private int weight;
    private int size;
    private ArrayList<Item> items;

    public KnapSack(int weight, int size, ArrayList<Item> items) 
    {
        this.weight = weight;
        this.size = size;
        this.items = items;
    }

    //Generate KnapSack from file
    public KnapSack(String filename) //actually going to be used when reading the file.
    {
        this.items = new ArrayList<Item>();
        try
        {
            System.out.println("Reading " + filename + " ....");
            FileReader fileReader = null;
            try
            {
                fileReader = new FileReader(filename);
                BufferedReader reader = new BufferedReader(fileReader);

                //read in weight and size capacities from the first line
                String line = reader.readLine();
                line.split(" ");
                this.weight = Integer.parseInt(line.split(" ")[0]);
                this.size = Integer.parseInt(line.split(" ")[1]);

                //read in items from the rest of the file
                while ((line = reader.readLine()) != null)
                {
                    items.add(new Item(line));
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

// All/most code below this point is LLM auto-completed code for helpers, getters, setters, and/or toString methods.
//implement setters and getters
    public int getWeight() 
    {
        return weight;
    }
    public void setWeight(int weight) 
    {
        this.weight = weight;
    }
    public int getSize() 
    {
        return size;
    }
    public void setSize(int size) 
    {
        this.size = size;
    }
    public ArrayList<Item> getItems() 
    {
        return items;
    }
    public void setItems(ArrayList<Item> items) 
    {
        this.items = items;
    }

    @Override
    public String toString() {
        StringBuilder itemsString = new StringBuilder();
        for (int i = 0; i < this.items.size(); i++) {
            itemsString.append(this.items.get(i).toString()).append((i < this.items.size() - 1 ? "\n" : ""));
        }
        return "Knapsack weight: " + weight + "\nKnapsack size: " + size + "\nNumber of items: "+ this.items.size() + "\n" + itemsString.toString();
    }
}
