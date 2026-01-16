ALGORITHM SubMySet(S)

INPUT: a set S containing n items
OUTPUT: a set T containing all subsets of s (not including the null set)

For each i in S:
	T’ -> set of saved sets.
	T’ <- T //T will hold all previously found sets, and the set of just i. 
	for each s in T:
		s.add(i) // add the next “floor” to all discovered sets after they have been copied and saved
	T’.add(i) //add the set of just i.
	T = T= T’ // doubles arr size during each iteration.
