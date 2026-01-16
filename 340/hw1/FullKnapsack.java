package hw1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
//import time for timing operations
import java.time.LocalTime;
import java.util.Scanner;



public class FullKnapsack {
    

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the input file name: ");
        String filename = sc.nextLine();

        LocalTime before = LocalTime.now();
        KnapSack ks = new KnapSack(filename);
        System.out.println(ks);
        ArrayList<Item> subsets = ks.getItems();


        //printSubsets(subsets); debug line

        LocalTime after = LocalTime.now();
        System.out.println("Total running time: " + ((after.getNano() - before.getNano())/1000000000.0) + " seconds");
    }

        
}
