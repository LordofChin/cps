.data
msg: .ascii "the value of $t3 register is "
null_1: .space 1
next_msg: .ascii "i'm dumb as hell"
null_2: .space 2

.text
la $a0, msg
li $v0, 4
syscall

li $t1, 10
li $t2, 10

beq $t1, $t2, label	# jump to label
li $t3,100
j print			# jump to print
label:
li $t3, 200	# label
j print			# jump to print	
print:		# print
add $a0, $t3, $zero
li $v0, 1
syscall
li $v0, 10
syscall

