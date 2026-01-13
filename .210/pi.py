pi = 0.14
count = 1
while(True):
	pi = pi * 2
	if pi > 1:
		print (1, " ", count, " ", pi)
		pi -= 1
	elif pi ==1:
		print (1)
		print(count)
		break
	else:
		print (0, " ", count, " ", pi)
	if count == 22:
		break
	count += 1

