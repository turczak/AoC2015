# --- Day 9: All in a Single Night ---

Every year, Santa manages to deliver all of his presents in a single night.

This year, however, he has some new locations to visit; his elves have provided him the distances between every pair of
locations. He can start and end at any two (different) locations he wants, but he must visit each location exactly once.
What is the **shortest distance** he can travel to achieve this?

For example, given the following distances:

* `London to Dublin = 464`
* `London to Belfast = 518`
* `Dublin to Belfast = 141`

The possible routes are therefore:

* `Dublin -> London -> Belfast = 982`
* `London -> Dublin -> Belfast = 605`
* `London -> Belfast -> Dublin = 659`
* `Dublin -> Belfast -> London = 659`
* `Belfast -> Dublin -> London = 605`
* `Belfast -> London -> Dublin = 9821`

The shortest of these is `London -> Dublin -> Belfast = 605`, and so the answer is 605 in this example.

What is the distance of the shortest route?

To begin, [get your puzzle input](https://github.com/turczak/AoC2015/tree/main/src/main/resources/inputs/day09.txt).

Your puzzle answer was `117`.

<code style="color : gold">The first half of this puzzle is complete! It provides one gold star: *</code>

## --- Part Two ---

The next year, just to show off, Santa decides to take the route with the **longest distance** instead.

He can still start and end at any two (different) locations he wants, and he still must visit each location exactly
once.

For example, given the distances above, the longest route would be 982 via (for example) `Dublin -> London -> Belfast`.

What is the distance of the longest route?

Your puzzle answer was `909`.

<code style="color : gold">Both parts of this puzzle are complete! They provide two gold stars: **</code>
