#include <cassert>

#include "part1.h"

void test(void)
{
    int total{0};

    vector<string> lines = {
        "1abc2",
        "pqr3stu8vwx",
        "a1b2c3d4e5f",
        "treb7uchet",
    };

    assert(find_value(lines.at(0)) == 12);
    assert(find_value(lines.at(1)) == 38);
    assert(find_value(lines.at(2)) == 15);
    assert(find_value(lines.at(3)) == 77);

    for (auto &line : lines)
    {
        total += find_value(line);
    }

    assert(total == 142);
}

int main(void)
{
    test();

    return 0;
}