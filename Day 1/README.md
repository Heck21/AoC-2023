# Day 1

## Problem

https://adventofcode.com/2023/day/1

## Part 1

Was able to complete part 1 relatively easily.

## Part 2

Part 2 offered a lot of challenges since I'm not familiar with regex.

### Problems Encountered

1. Finding out how to parse each line to get all the values.
2. Finding a good way to convert the worded forms of the numbers to their numeric forms.
3. Dealing with edge cases like `oneight`.

### How I Solved Each Problem

#### Problem 1

I settled on looping over each character in the line and storing it in a buffer.

This works but is not very efficient, and it led to some issues when testing that had to be fixed.

#### Problem 2

At first I thought of using a hash map with the worded form as the key and the numeric form as the value, but this ended up being really cumbersome to use, especially in C++.

So after analyzing some submissions I arrived at using a list.

The numeric form was obtained by checking if a value from the list was in the buffer and then using the index of the worded form in the list.

This is not efficient since it requires checking if each value in the list is in the buffer.

#### Problem 3

Because of how I parsed each line. A string like `2oneight` would end up with the values 2 and 1.

This is because whenever I matched a value I would clear the buffer, so `2` and `one` would be removed which would leave `ight`.

This was fixed by keeping the last character of the buffer even when a match was found.
