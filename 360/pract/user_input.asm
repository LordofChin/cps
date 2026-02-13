.data 
promptMsg: .asciiz "Enter your number "
oddMsg: .asciiz " is odd"
evenMsg: .asciiz " is even"

.text
main:
jal prompt		# initiate prompting step
jal processInput	# initiate processing step-
j exit			# close the program

prompt:
la $a0, promptMsg	# load the message to print
li $v0, 4		# load the string print service
syscall			# print the input message
j input			# proceed to collect user input segment

input:
li $v0, 5		# load int-read service
syscall			# execute input read
add $t0, $v0, $zero	# move the input out of the volatile $v0 register
jr $ra			# return to place in main method

printInput:
add $a0, $t0, $zero	# move the integer into the printable register
li $v0, 1		# load int-print service
syscall			# print the int
li, $v0, 4 		# prepare for the coming string print 
andi $t1, $t0, 1	# perform input-int mod 2
beq $t1, $zero, even	# jump if input-int was even
odd:
la $a0, oddMsg		# load the odd message
syscall 		# print the odd message
jr $ra			# jump back to main
even:			
la $a0, evenMsg		# load the even message
syscall			# print the even message
jr $ra			# jump back to the main method

exit:
li $v0, 10		# load the terminate execution service
syscall			# execute the terminate execution service
