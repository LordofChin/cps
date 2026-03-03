.data
prompt1: .asciiz "enter your first number: "
prompt2: .asciiz "enter your second number: "
loResult: .asciiz "the lower 32 bits after multiplication is: "
hiResult: .asciiz "\nthe upper 32 bits after multiplication is: "
quResult: .asciiz "\nthe quotient is: "
reResult: .asciiz "\nthe remainder is: "
newLine: .asciiz "\n"

.text
# take arg #1
li $v0, 4
la $a0 prompt1
syscall

li $v0, 5
syscall
move $t1, $v0

# take arg #2
li $v0, 4
la $a0 prompt2
syscall

li $v0, 5
syscall
move $t2, $v0

#process
mult $t1, $t2
mflo $t3
mfhi $t4

#print the new line
li $v0, 4
la $a0, newLine #print the quotient
syscall

# output result lo
li $v0, 4
la $a0, loResult
syscall

li $v0, 1
add $a0, $t3, $zero
syscall

# output result hi
li $v0, 4
la $a0, hiResult
syscall

li $v0, 1
add $a0, $t4, $zero
syscall

#print the new line
li $v0, 4
la $a0, newLine #print the quotient
syscall

# divide the inputs
div $t1, $t2
mflo $t3 # store the quotient
mfhi $t4 # store the remainder

#print the quotient message
li $v0,4 
la $a0, quResult
syscall

#print the quotient
li $v0,1 
move $a0, $t3
syscall

#print the quotient message
li $v0,4 
la $a0, reResult
syscall

#print the quotient
li $v0,1 
move $a0, $t4
syscall

# close the program
li $v0, 10
syscall




