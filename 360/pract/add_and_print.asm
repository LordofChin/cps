.data
A: .word 5,10

.text
la $s0, A

lw $t1, 0($s0)
lw $t2, 4($s0)

add $t3, $t2, $t1
add $a0, $t3, $zero
li $v0, 1
syscall