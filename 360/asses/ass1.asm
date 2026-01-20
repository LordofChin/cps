.data

msg: .asciiz "Welcome to CPS" # z for line terimator, store desired msg to print

.text

li $v0, 4 # load string print service number onto register v0 (used by syscall)
la $a0, msg #store var msg for message in address a0, accessable by v0
syscall #syscall to execute the service in v0

li $v0, 1 # load integer print service number onto register v0 (used by syscall)
li $a0, 360 # load immediate integer value of 360 for the class section identifier in address a0, accessible by v0.
syscall # syscall to execute the service in v0
