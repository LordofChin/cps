//Item class data describes an item with name, weight, size, and value.
public class Item {
    private String name;
    private float weight;
    private float size;
    private float value;

    public Item(String name, float weight, float size, float value) 
    {
        this.name = name;
        this.weight = weight;
        this.size = size;
        this.value = value;
    }

    //Generate Item from line in file
    public Item(String line) //actually going to be used when reading the file.
    {
        String[] parts = line.split(" ");
        this.name = "Item " + parts[0];
        this.weight = Float.parseFloat(parts[1]);
        this.size =   Float.parseFloat(parts[2]);
        this.value =  Float.parseFloat(parts[3]);
    }

// All/most code below this point is LLM auto-completed code for helpers, getters, setters, and/or toString methods.
// implement setters and getters
    public float getWeight() 
    {
        return weight;
    }
    public void setWeight(float weight) 
    {
        this.weight = weight;
    }
    public float getValue() 
    {
        return value;
    }
    public void setValue(float value) 
    {
        this.value = value;
    }
    public float getSize() 
    {
        return size;
    }
    public void setSize(float size) 
    {
        this.size = size;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    @Override
    public String toString() 
    {
        return this.name + " (weight, size, value): " + weight + " " + size + " " + value;
    }

}
