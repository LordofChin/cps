.data
prompt1: .asciiz "today we are dividing 8 from 16!"
quResult: .asciiz "\nthe quotient is: "
reResult: .asciiz "\nthe remainder is: "
newLine: .asciiz "\n"

.text
# take arg #1
li $v0, 4
la $a0 prompt1
syscall

#load the values
li $t1, 16
li $t2, 8

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




