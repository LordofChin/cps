.data
result: .asciiz "the result is "


.text
li $v0,4
la $a0, result
syscall			# print result msg

li $a0, 5
li $a1, 11
jal add_function
add $a0, $v0, $zero 
li $v0, 1
syscall

j exit

add_function:
add $v0, $a0, $a1
jr $ra			# jump or interpret junk forever

exit:
li $v0, 10
syscall
