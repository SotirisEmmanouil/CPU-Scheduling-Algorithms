FIRST COME FIRST SERVE SCHEDULING:

Input: is received through a hard coded array of burst times for each process

Methods: There are two methods which receive the burst time array as a parameter and calculates the average wait and turn around times respectively.
The main method prints out the Gantt chart, average turn around, and average wait time.

The overall code for this algorithm is implemented in one Java file with two methods that does all of the necessary computations.


SHORTEST JOB FIRST ALGORITHM:

Input: The input is received via a hard coded array of CPU burst times.

Methods: The methods used to implement this algorithm are the same as the the FCFS methods. However, these methods now receive a sorted array of burst times so as to allow the shortest jobs to execute first. 

The algorithm is implemented in the same java file as the FCFS algorithm.


PRIORITY SCHEDULING ALGORITHM:

Input: All input is hard coded. 
The input is placed into a "Process" constructor called "PS" along with a randomly generated arrival time, which is then placed in a "Processes" ArrayList. 

Methods: There are two methods besides the main method in this java file, which calculate the wait and turn-around times. There is also a CustomComparator class that will do the comparison of arrival times 

The creation of process object was ideal in this scenario due to the processes needing to be sorted by and arrival time and in worst case, priority. 

This algorithm is contained within two java files: PS.java and CustomComparator.java.

ROUND ROBIN ALGORITHM:

Input: I implemented this algorithm via a hard coded list of integers which represent the burst times. 

Methods: There are no methods besides the main method which runs the whole algorithm. There is a variable which holds the time quantum.

The whole algorithm is implemented in one java file.
