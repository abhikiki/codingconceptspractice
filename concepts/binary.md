
# Binary Important points
- https://medium.com/techie-delight/bit-manipulation-interview-questions-and-practice-problems-27c0e71412e7 
- 
* -1=~0\
* -a=~(a-1)\
* a & (~a) = set last 1 in binary representation to 0\
* a & (-a) = a & ~(a - 1)  means keep only last 1 of the binary representation and set all 1s to 0\
* Find a number is positive or not using binary operation only: (num >> Integer.BYTES*8 - 1) & 1 == 1 then -ve else +ve
* 
