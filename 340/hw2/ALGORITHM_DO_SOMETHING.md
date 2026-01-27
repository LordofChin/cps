ALGORITHM DoSomething(n)
INPUT: A positive integer n
OUTPUT: s, the summation of each element cubed in the set ℤ {0...n} 

IF n == 1					# base case
	return 1 				# starts with 1
ELSE
	return DoSomething(n-1) + n * n * n	# 1 + 2^3 
						# 9 + 3^3
						# 36 + 4^3
						# 100 + 5^3
						# 225 + 6^3
						# 441 + 7^3...

Part 2.1:
	This algorithm finds the summation of cubes for numbers n to 1;
	The algorithm outputs s, the summation of each element cubed in the set ℤ {0...n} 
Part 2.2:
	
	