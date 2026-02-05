ALGOTRITHM TowerOfHanoi(disk, src, dst, tmp)
INPUT: n disks, 3 poles (src, dst, tmp)
OUTPUT:n disks at dst

IF disk > 0 do:
	MoveTower(disk -1, src, tmp, dst)
	move disk from src to dst
	MoveTower(disk -1, tmp, dst, src)
