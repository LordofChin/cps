ALGORITHM FullKnapsack

INPUT: an input.txt file containing first row knapsack data in format "<weight_cap> <size_cap>" and subsequent row item data in format "<Name> <Weight> <Size> <Value>".
OUTPUT: process updates and queires are returned to console.

Step 1: Generate all possible subsets with the SubMySet algorithm.
Step 2: Check each subset to see if its valid (matches weight and size caps exactly)
Step 3: Check the remaining valid entries for the one with the highest value (if the same value exists, choose the first appearing one).
