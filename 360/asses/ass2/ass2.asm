# simulate c code: A[200] = e - f + A[100]
.data
A: .word 67:201 	# array A of element size word (32-bit "int"), filled with 201 elements of 67. 
e: .word 6		# e variable
f: .word 7		# f variable
.text

# prestore locations of A[100] and A[200]
la $s3, A		# load intial address of array into $s3 as specified
li $t1, 100		# store int 100 			- for finding offset 
li $t2, 4		# word is of length 4 bytes		- for finding offset
mult $t1, $t2		# calc offset for the 100th element of type word
mflo $t2 		# store offset for A[100] in $t2
add $t1, $s3, $t2	# prestore loc(A[100]) in $t1 using stored offset for A[100]
add $t2, $t1, $t2	# prestore loc(A[200]) in $t2 		- add prestored offest of 100 words to loc(A[100]) for loc(A[200])

# load e and f variables
lw $t3, e		
lw $t4, f		# load variables to add

# compute 

sub $t3, $t3, $t4	# find e - f segment
lw $t4, 0($t1)		# load word/int at A[100] for + A[100] segment
add $t3, $t3,  $t4	# find + A[100] segment
sw $t3, 0($t2)		# store results in prestored location of A[200]

lw $a0, 0($t2)		# load result for verifying/printing by syscall's int-print service
li $v0, 1		# load the int-print service for syscall to execute
syscall			# execute the service stored in $v0 on word in $a0

