Write a program that helps seat audiences in a flight based on the
following input and rules.
Rules for seating
• Always seat passengers starting from the front row to back,
starting from the left to the right
• Fill aisle seats first followed by window seats followed by center
seats (any order in center seats)
Input to the program will be
• a 2D array that represents the rows and columns [ [3,4], [4,5],
[2,3], [3,4] ]
• Number of passengers waiting in queue.


Input :

A 2D array that represents the rows and columns
[ [3,2], [4,3], [2,3], [3,4] ]
If there were 30 passengers from then the seating output will be …

Output :

19  25   1       2  26  27   3       4   5       6  28  20     
 21  29   7       8  30   0   9      10  11      12   0  22     
*** *** ***      13   0   0  14      15  16      17   0  23     
*** *** ***     *** *** *** ***     *** ***      18   0  24   


0 - represents unfilled seats
* - no seats
