from math import ceil, sqrt, pow

n = 1
max_val = (2 * pow(10,9))

while( n != 0 ):
	n = float(raw_input())
	if( n >= 1 and n <= max_val ):
		print int(ceil(sqrt(n)))
