# add vs addu
	# addu ignores all overflow
.data
msg: .asciiz "we are adding 2147483647 with addu and add!"
adduMsg: .asciiz "\naddu result: "
addMsg: .asciiz "\nadd result: "

.text
.globl main
main:
li $t1, 0X7FFFFFFF 	# pow(2,31) is the maximum signed int 2147483647
li $t2, 1

#add $t0, $t1, $t2

addu $t3, $t1, $t3

li $v0, 4
la $a0, adduMsg
syscall
li $v0, 1
add $a0, $t3, $zero
syscall

li $v0, 4
la $a0, addMsg
syscall
li $v0, 1
add $a0, $t0, $zero
syscall


