#Printing a String
.data
msg: .asciiz "Hello World"

.text
li $v0, 4 # print a string 
la $a0, msg
syscall