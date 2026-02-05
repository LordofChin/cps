Recurrence relation:
	Binary Search: 		T(n) + T(n/2) + O(1) + T(1) = 1
	Merge Sort: 		T(n) = 2T(n/2) + n, T(1) = 1 			# n is for back merging, 2T(n/2) is for building arrays
	Calc Fibonnaci: 	T(n) = T(n-1) + T(n-2) + 1, T(1) = 1, T(2) = 1
	Calc Facorial: 		T(n) = T(n-1) + 1, T(1) = 1			
	Tower of Hanoi: 	T(n) = h + 1 + T(n-1), T(1) = 1 		# T(n-1) -> sort n-1 disks, 1 -> moving disk n, sort n-1 disks again.

Find closed formula:
	general method:
		recurrence tree
		substitution
		master theorem
	
	recurence tree:
		1. tree of sub-problems
		2. sum of sub-problems
		

T(n/2^i)+ai, T(1)=b
n/2^i = 1
2^i = n 
i = log_2(n)
b+a(log_2(n))
or essentiall O(log(n))

recursice space complexity is log(n) while iterative is O(1)