ALGORITHM BinarySearch (A[0..n-1], n, x)
INPUT: Array A of n floating-point numbers, and target x
OUTPUT: Index i such that A[i] = x, or -1 if x not found

Iterative:
	low <- index of first element			
	high <- index of last element			# define low and high bounds for search space

	do:	
    		mid <- index of the "middle" element	# calculate the bisect (middle) of the search space
    		midVal <- A[mid]				
    		if  midVal == x:			# found x, return now
        		return mid;				
    		else:					# didn't find x, divide and conquer from here
        		if midVal < x				# divide from low-end (search space divided in half)
            		low <- mid + 1
        		else					# divide from high-end (search space divided in half) 
            		high = mid - 1
	while: 
    		low <= high				# run until low and high converge (no x is found)
    		
	return -1					# no index was found

Recursive:



