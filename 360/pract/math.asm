.data
msg: .asciiz " sigma"

.text
li $t1, 60		# make 60 real
li $t2, 7		# make 7 real
add $a0, $t1, $t2	# store result in a place accessable by syscall

li $v0, 1		# print value in a0
syscall			# 67 _-

la $a0, msg
li $v0, 4
syscall

# lw $t0 48($s3) # loads word, 48 bytes after s3