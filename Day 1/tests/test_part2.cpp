#include <cassert>

#include "part2.h"

void test(void)
{
    [[maybe_unused]] int total{0};

    [[maybe_unused]] vector<string> lines = {
        "two1nine",
        "eightwothree",
        "abcone2threexyz",
        "xtwone3four",
        "4nineeightseven2",
        "zoneight234",
        "7pqrstsixteen",
    };

    assert(find_value(lines.at(0)) == 29);
    assert(find_value(lines.at(1)) == 83);
    assert(find_value(lines.at(2)) == 13);
    assert(find_value(lines.at(3)) == 24);
    assert(find_value(lines.at(4)) == 42);
    assert(find_value(lines.at(5)) == 14);
    assert(find_value(lines.at(6)) == 76);

    for (auto &line : lines)
    {
        total += find_value(line);
    }

    assert(total == 281);
}

int main(void)
{
    test();

    return 0;
}