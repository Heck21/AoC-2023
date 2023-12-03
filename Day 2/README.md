# Day 2

# Problem

https://adventofcode.com/2023/day/2

## Part 1

This took a long time since parsing the data was tedious.

## Part 2

This was easier since a majority of the work was already completed from part 1.

### Problems Encountered

1. Parsing the data given.

### How Problems Were Solved

#### Problem 1

The semi-colons and commas were interfering with my logic so I removed them and then split on spaces.

To keep track of the color of the dice I checked if the index in the sub list of the parsed data was even, the value was checked and then the index before was used to get the value.
