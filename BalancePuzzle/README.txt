Balance Puzzle Kata

Years ago I was introduced to this puzzle:
"Let there be 8 identical marbles, all identical to each other except for 
one of them is heavier than the rest.
Using some old-fashioned scales balance to weigh the marbles, 
the goal is to find the heavier marble in the least possible weighings."

More can be found on Wikipedia:
http://en.wikipedia.org/wiki/Balance_puzzle

The puzzle sets a nice scenario for doing some TDD. I would personally suggest 
to begin with a very humble set of tests that will then prove useful:

- Find the heaviest marble in a set of 1, 2, and 3 marbles
- Assert that for these cases it takes 0, 1, and 1 again, weighins to find out. 

The goal of the kata is to find out an implementation that can sort it out for 8 marbles
in 2 turns, and even find it in 1 turn if the necessary conditions arise.
 
It's likely that binary search will be your first attempt, and it will certainly do well
for the first cases. But it will just fail to find it out in 2 turns with 8 marbles.

Just in case you want to take it one step further, how about not knowing if the offending
marble is heavier of lighter? Would it only impact on the number of turns used to
discover the marble? Or would it render your implementation buggy or even useless?
