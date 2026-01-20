package hw1;

import java.util.*;

//All or most of the code in the class is taken directly from Dr. Liao's (CMICH-U) lecture notes on subsets.
public class Subsets 
{
	private ArrayList<ArrayList<Item>> subsets;

	public Subsets(ArrayList<Item> items) 
	{
		subsets = findSubsets(items);
	}

    public static ArrayList<ArrayList<Item>> findSubsets(ArrayList<Item> items) 
	{
		ArrayList<ArrayList<Item>> subsets = new ArrayList<ArrayList<Item>>();
		for (int i = 0; i < items.size(); i++) {   // for each element in the set

			// make a copy of all existing subsets.
			ArrayList<ArrayList<Item>> copy = new ArrayList<ArrayList<Item>>();
			for (ArrayList<Item> a : subsets)
				copy.add(new ArrayList<Item>(a));

			// add the new element to each of existing subsets
			for (ArrayList<Item> a : copy)
				a.add(items.get(i));
			
			// add the new element as a standalone set
			ArrayList<Item> s = new ArrayList<Item>();
			s.add(items.get(i));
			copy.add(s);

			subsets.addAll(copy);
		}
        return subsets;
    }

// All/most code below this point is LLM auto-completed code for helpers, getters, setters, and/or toString methods.

	//setters and getters
	public ArrayList<ArrayList<Item>> getSubsets() {
		return subsets;
	}
	

	@Override
	public String toString() 
	{
		StringBuilder sb = new StringBuilder();
		for (ArrayList<Item> l : subsets) {
			sb.append("{ ");
			for (int i = 0; i < l.size(); i++) {
				Item item = l.get(i);
				sb.append(item.getName() + (i < l.size() - 1 ? ", " : " "));
			}
			sb.append("}\n");
		}
		return sb.toString();
    }
}
