.data

.text
li $t1, -1
li $t2, 1

slt $t3, $t1, $t2		# is 1

sltu $t4, $t1, $t2		# is 0

li $v0, 1
add $a0, $t3, $zero
syscall
add $a0, $t4, $zero
syscall				# output is 10