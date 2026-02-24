.data

# store user interface messages

welcomeMsg: .asciiz "welcome to the subtraction program!\n"

promptMsg1: .asciiz "Please enter integer to subtract from: "

promptMsg2: .asciiz "Please enter integer to subtract: "

outputMsg: .asciiz "The result of the subtraction is: "



.text

# welcome the user

li $v0, 4

la $a0, welcomeMsg

syscall



# prompt for the first argument

la $a0, promptMsg1

syscall

li $v0, 5

syscall

add $t1, $v0, $zero



# prompt for the second argument

li $v0, 4

la $a0, promptMsg2

syscall

li $v0, 5

syscall

add $t2, $v0, $zero



#process the input

sub $t0, $t1, $t2



# output the results of the process

li $v0, 4

la $a0, outputMsg

syscall

li $v0, 1

add $a0, $t0, $zero

syscall