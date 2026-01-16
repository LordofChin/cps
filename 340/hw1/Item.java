package hw1;

public class Item {
    private String name;
    private int weight;
    private int size;
    private float value;

    public Item(String name, int weight, int size, float value) {
        this.name = name;
        this.weight = weight;
        this.size = size;
        this.value = value;
    }

    public Item(String line) { //actually going to be used when reading the file.
        String[] parts = line.split(" ");
        this.name = parts[0];
        this.weight = Integer.parseInt(parts[1]);
        this.size = Integer.parseInt(parts[2]);
        this.value = Float.parseFloat(parts[3]);
    }

    //implement setters and getters
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public float getValue() {
        return value;
    }
    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Item " + this.name + " (weight, size, value): " + weight + " " + size + " " + value;
    }

}
