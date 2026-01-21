//FullKnapSack4Bash class to solve the full knapsack problem using brute force method, adapted for bash script usage.

import java.util.ArrayList;

public class FullKnapSack4Bash {
    
    private KnapSack ks;
    private ArrayList<ArrayList<Item>> subsets;
    private ArrayList<Item> optimalPacking;

    public FullKnapSack4Bash(String filename) 
    {
        this.ks = new KnapSack(filename);
        this.subsets = Subsets.findSubsets(ks.getItems());
        this.optimalPacking = findOptimalPacking(this);
    }

    public static void main(String[] args) {
        String filename = args[0]; // get filename from command line argument for bash script implementation

        long before = System.currentTimeMillis();
        FullKnapSack4Bash fullKS = new FullKnapSack4Bash(filename);
        System.out.println(fullKS.getKS());

        System.out.println("Finding optimal packing ....");

        if (fullKS.getOptimalPacking().size() == 0)
            System.out.println("No packing is found.");
        else
        {
            System.out.printf("Found a packing!\nTotal weight: %.2f\nTotal size: %.2f\nTotal value: %.2f\n%s\n",
                calculateWeight(fullKS.getOptimalPacking()),
                calculateSize(fullKS.getOptimalPacking()),
                calculateValue(fullKS.getOptimalPacking()),
                fullKS.optimalPackingToString()
            );
        }
        //Subsets.printSubsets(fullKS.getSubsets()); //debug line

        long after = System.currentTimeMillis();
        System.out.println("Total running time: " + ((after - before) / 1000.0));
    }

    public static ArrayList<Item> findOptimalPacking(FullKnapSack4Bash fullKS) {

        // create a subset of only valid subsets (those that match weight and size constraints exactly)
        ArrayList<ArrayList<Item>> validSubsets = new ArrayList<ArrayList<Item>>();

        for (ArrayList<Item> subset : fullKS.getSubsets()) {
            if (calculateWeight(subset) == fullKS.getKS().getWeight() && calculateSize(subset) == fullKS.getKS().getSize())
                validSubsets.add(subset);
        }

        // find the optimal packing among valid subsets
        ArrayList<Item> optimalPacking = new ArrayList<Item>();
        float maxValue = 0;
        for (ArrayList<Item> subset : validSubsets) {
            float value = calculateValue(subset);
            if (value > maxValue) {
                maxValue = value;
                optimalPacking = subset;
            }
        }
        return optimalPacking;
    }

// All/most code below this point is LLM auto-completed code for helpers, getters, setters, and/or toString methods.
// helper methods to find optimal packing
    public static float calculateValue(ArrayList<Item> items) {
        float totalValue = 0;
        for (Item i : items) {
            totalValue += i.getValue();
        }
        return totalValue;
    }

    public static float calculateWeight(ArrayList<Item> items) {
        float totalWeight = 0;
        for (Item i : items) {
            totalWeight += i.getWeight();
        }
        return totalWeight;
    }

    public static float calculateSize(ArrayList<Item> items) {
        float totalSize = 0;
        for (Item i : items) {
            totalSize += i.getSize();
        }
        return totalSize;
    }

    //setters and getters
    public KnapSack getKS() {
        return ks;
    }
    public void setKS(KnapSack ks) {
        this.ks = ks;
    }
    public ArrayList<ArrayList<Item>> getSubsets() {
        return subsets;
    }
    public void setSubsets(ArrayList<ArrayList<Item>> subsets) {
        this.subsets = subsets;
    }
    public ArrayList<Item> getOptimalPacking() {
        return optimalPacking;
    }
    public void setOptimalPacking(ArrayList<Item> optimalPacking) {
        this.optimalPacking = optimalPacking;
    }

    public String optimalPackingToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Packing: ");
        for (int i = 0; i < this.getOptimalPacking().size(); i++) {
            sb.append(this.getOptimalPacking().get(i).getName().toString() + (i < this.getOptimalPacking().size() - 1 ? ", " : ""));
        }
        return sb.toString();
    }
}
