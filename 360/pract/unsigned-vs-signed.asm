.data
msg: .asciiz "the result of -10 / 3"
sloMsg: .asciiz "\nsigned division quotiuent: "
shiMsg: .asciiz "\nsigned division remainder: "
uloMsg: .asciiz "\nunsigned division quotient: "
uhiMsg: .asciiz "\nunsigned division remainder: "
.text
.globl main
main: 

li $t0, -10	# dividend
li $t1, 3	# divisor

# perform signed division
div $t0, $t1

# store signed results
mflo $t2	# get quotient
mfhi $t3	# get remainder

# perform unsigned division
divu $t0, $t1

# store the unsigned results
mflo $t4	# get quotient
mfhi $t5	# get remainder

#print message
la $a0, msg
li $v0, 4
syscall

#print signed quotient message
la $a0, sloMsg
li $v0, 4
syscall

# printing the signed quotient
add $a0, $t2, $zero
li $v0, 1
syscall

#print signed remainder message
la $a0, shiMsg
li $v0, 4
syscall

# printing the signed remainder
add $a0, $t3, $zero
li $v0, 1
syscall

#print unsigned quotient message
la $a0, uloMsg
li $v0, 4
syscall

# printing the unsigned quotient
add $a0, $t4, $zero
li $v0, 1
syscall

#print unsigned remainder message
la $a0, uhiMsg
li $v0, 4
syscall

# printing the unsigned remainder
add $a0, $t5, $zero
li $v0, 1
syscall

# close the program
li $v0, 10
syscall




