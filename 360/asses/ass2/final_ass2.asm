# simulate c-code: A[200] = e - f + A[100]
.data 
# store known variables for code readability
A: .word 67:1000 		# 67-fill a 1000-word-length array
e: .word 6			# ass e -> 6
f: .word 7			# ass f -> 7

.text
# perform "e - f" segment
lw $t0, e			# load e
lw $t1, f			# load f
sub $t0, $t0, $t1		# calc-n-sto "e - f" segment

# perform "+ A[100]" segment
#la $t2, A			# load addr(A[0]) - keep ref open for sw
lui $t2, %hi(A)
ori $t2, $t2, %lo(A)
lw $t1, 400($t2)		# deref//lw @ A[100] with offset 100 * 4//len(word)
add $t0, $t0, $t1		# calc-n-sto "+ A[100]" segment

# perform "A[200] ="//store solution in A[200]
sw $t0, 800($t2)		# deref//sw @ A[200] with offset 200 * 4//len(word)

# print result for debug//grading
add $a0, $t0, $zero		# load int-to-print into $a0 for $v0 to ref
la $v0, 1			# load int-print svc into $v0 for syscall to ref
syscall				# execute loaded syscall
