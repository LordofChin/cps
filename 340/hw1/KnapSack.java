package hw1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class KnapSack {
    private int weight;
    private int size;
    private ArrayList<Item> items;

    public KnapSack(int weight, int size, ArrayList<Item> items) {
        this.weight = weight;
        this.size = size;
        this.items = items;
    }

    public KnapSack(String filename) 
    {
        this.items = new ArrayList<Item>();
        try
        {
            System.out.println("Reading " + filename + " ...");
            FileReader fileReader = null;
            try
            {
                fileReader = new FileReader(filename);
                BufferedReader reader = new BufferedReader(fileReader);
                String line = reader.readLine();
                line.split(" ");
                this.weight = Integer.parseInt(line.split(" ")[0]);
                this.size = Integer.parseInt(line.split(" ")[1]);

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

    //implement setters and getters
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }


    @Override
    public String toString() {
        StringBuilder itemsString = new StringBuilder();
        for (Item item : this.items) {
            itemsString.append(item.toString()).append("\n");
        }
        return "Knapsack weight: " + weight + "\nKnapsack size: " + size + "\nNumber of items: "+ this.items.size() + "\n" + itemsString.toString();
    }
}
