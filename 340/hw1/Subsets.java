package hw1;

import java.lang.reflect.Array;
import java.util.*;

/* CPS 340
 * Dr. Qi Liao
 * Implementation of subsets finding algorithm
 */
public class Subsets {
	private ArrayList<ArrayList<Item>> subsets;

	public Subsets(Item[] set) {
		subsets = findSubsets(set);
	}

    public static ArrayList<ArrayList<Item>> findSubsets(Item[] set) {
		ArrayList<ArrayList<Item>> subsets = new ArrayList<ArrayList<Item>>();
		for (int i = 0; i < set.length; i++) {   // for each element in the set

			// make a copy of all existing subsets.
			ArrayList<ArrayList<Item>> copy = new ArrayList<ArrayList<Item>>();
			for (ArrayList<Item> a : subsets)
				copy.add(new ArrayList<Item>(a));

			// add the new element to each of existing subsets
			for (ArrayList<Item> a : copy)
				a.add(set[i]);

			// add the new element as a standalone set
			ArrayList<Item> s = new ArrayList<Item>();
			s.add(set[i]);
			copy.add(s);

			subsets.addAll(copy);
		}
        return subsets;
    }

    public static void printSubsets(ArrayList<ArrayList<Item>> subsets) {
        for (ArrayList<Item> l : subsets) {
            for (Item i : l)
                System.out.print(i + ",");
            System.out.println();
        }
    }

	//setters and getters
	public ArrayList<ArrayList<Item>> getSubsets() {
		return subsets;
	}
	
	public void setSubsets(ArrayList<ArrayList<Item>> subsets) {
		this.subsets = subsets;
	}
}
