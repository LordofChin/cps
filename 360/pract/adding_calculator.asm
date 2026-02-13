.data
welcomeMsg: 	.asciiz "Welcome to Carter's Beautiful Adder!\n"
sizeMsg: 	.asciiz "How many arguments would you like? "
promptMsg: 	.asciiz "int to add: "
resultMsg: 	.asciiz "the result of the additon is "
argLen: 	.word 2		# array to store the index size of the argArr
argArr: 	.space 400 	# 100 word length array 

.text
main:
jal 	prompt			# initiate a loop to coolect all the users happy arguments
jal 	processInput		# initiate an add loop to add all the happy numbers
jal 	print			# print the output of the addition
j 	exit			# exit the program 

prompt:
la 	$a0, welcomeMsg
li 	$v0, 4
syscall				# welcome user
la 	$a0, sizeMsg
syscall				# ask for amount of arguments
li 	$v0, 5 
syscall				# receive arguments count
add 	$t0, $v0, $zero		# store arg count in a register
sll 	$t0, $t0, 2 		# multiply arg count by 4 for word size
la 	$t1, argLen		# get address of argLen for storing
sw 	$t0, 0($t1)		# override/store the array length for reference
la 	$t1, argArr		# load array address to iterate through
promptLoop:
li 	$v0, 4
la 	$a0, promptMsg
syscall				# prompt for argument
li 	$v0, 5 
syscall				# receive argument
add 	$t4, $t0, $t1
sw 	$v0, 0($t4)		# store result in the proper position in the array
subi 	$t0, $t0, 4		# remove word length to store next arg
bne 	$t0, $0, promptLoop 	# branch until all arguments are grabbed
jr 	$ra			# return to the main method

processInput:
lw 	$t0, argLen		# load arr length for iteration
la 	$t1, argArr
inputLoop:
add 	$t4, $t0, $t1		# compute the adress of the next array element from an offset
lw 	$t3, 0($t4)		# load the ith element of the array 
add 	$t2, $t2, $t3		# add to total sum
subi 	$t0, $t0, 4		# iterate by word length
bne 	$t0, $0, inputLoop	# branch until all arguments are added
jr 	$ra			# return to the main method

print:				# ts is all self explanatory U+1F940
la 	$a0, resultMsg
li 	$v0, 4
syscall
add 	$a0, $t2, $zero		# load result of iterative add
li 	$v0, 1
syscall
jr 	$ra

exit:
li 	$v0, 10
syscall
