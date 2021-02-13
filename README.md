# elephants-in-the-zoo
This is my first recruitment task:

All elephants in the Zoo are going to participate the upcoming parade. They have been lined up in a row by zoo employees, but the director did't like the order of elephants chosen by employees. He orered to rearrange the elephants according to his idea. To avoid chaos just before the parade, workers decided to rearrange the elephants, switching only two elephants at a time (they don't have to be next to each other in a row). Moving the elephant requires an effort equal to its weight, so the effort to switch two elephants with the masses m1 and m2 can be estimated by m1 + m2. What is the minimum effort required to bring all the elephants to their final positions?

There are for rows in the input file:
1. integer n (2 <= n <= 1 000 000 ) specyfing the number of elephants in the zoo
2. n integers m  (100 <= m <= 6500) speparated by single spaces, specyfing the weigths (in kg) of individual elephants 
3. n integers a (1 <= a <= n) speparated by single spaces, specyfing current elephants setting 
4. n integers b (1 <= b <= n) speparated by single spaces, specyfing target elephants setting 

The program should:
-read all all the necessary information from the standard input
-determine how to rearrange the elephants from their current to target order with the least possible effort
-write the total effort to the standard output (as the only line of output)
