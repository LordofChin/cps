import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

public class SumOfMaximums {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		final int BOUND = 51;
		// Create the list, of appropriate data structure

		MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<>();

		// Create the list of random integers, of appropriate data structure
		list.add(5); list.add(8); list.add(16); list.add(2);
		list.add(3); list.add(30); list.add(15); list.add(10);

		//Call the sumOfMaximums to display output for the list
		sumOfMaximums(list);

		//Ask user to enter the length of list		
		//Repeatedly 
		String userInput = "";
		int size = 0;
		while(true) {
			// Get user input size
			System.out.println("\nPlease enter the length of list for random integers: ");
			System.out.println("(Enter any non-integer value to terminate)");

			userInput = sc.next();
			try {
				size = Integer.parseInt(userInput);
			}catch(NumberFormatException e) {
				break;
			}
			//Create the list of random integers
			list = new MyDoublyLinkedList<>();
			for (int i = 0; i < size; i++) {
				list.add(rand.nextInt(BOUND));
			}

			//Calculate the sum of maximums of this list of random integers
			sumOfMaximums(list);
		}//End of while
		sc.close();
		System.out.println("Bye!");
	}//End of main

	/**
	 * sumOfMaximums: calculate the sum of maximums of the list according to definition.
	 * Output requirements:
	 * 	1) Output "---------------------------------"
	 * 	2) Output all elements in the list, in one line, separate elements using comma
	 * 	3) Output all maximums, in one line, separate by comma
	 * 	4) Output the sum of maximums.
	 * 	5) Output "---------------------------------"
	 * See sample output in the assignment sheet. 
	 * 
	 * @param list
	 */
	public static void sumOfMaximums(MyDoublyLinkedList<Integer> list) {
		ListIterator<Integer> it = list.iterator();
		StringBuilder sb = new StringBuilder();
		int max = Integer.MIN_VALUE;
		int temp;
		int index = -1;
		int sum = 0;
		ArrayList<Integer> maxList = new ArrayList<>();

		while(it.hasNext()) { //generate a string of all elements in the list
			temp = it.next();
			sb.append((it.hasNext()) ? (temp + ", ") : temp);
		}
		System.out.println("---------------------------------");
		System.out.println(sb);//print all elements in the list
		it = list.iterator();//reset the iterator to the beginning of the list

		while(list.size() > 0) { //find index of the maximum element in the list
			index = -1;
			max = Integer.MIN_VALUE;
			while(it.hasNext()) {
				temp = it.next();
				if (max < temp) {
					max = temp;
					index = it.previousIndex() + 1;
				};
			}
			maxList.add(max);//add the maximum element to the list of maximums

			list.removeAround(index);//revove the maximum element and its surrounding elements
			it = list.iterator(); //reset the iterator to the beginning of the list
		}

		sb = new StringBuilder();
		sb.append("The maximums: ");
		for (int i = 0; i < maxList.size(); i++) { //generate a string of all maximums in the list
			sb.append((i < maxList.size() - 1) ? (maxList.get(i) + ", ") : maxList.get(i));
		}
		System.out.println(sb);//print all maximums in the list

		for (int i = 0; i < maxList.size(); i++) {//calculate the sum of maximums
			sum += maxList.get(i);
		}
		System.out.println("Sum of maximums: " + sum);//print the sum of maximums
		System.out.println("---------------------------------");
	}
}
