#include <iostream>
#include <fstream>

#include "part1.h"

int main(void)
{
    int total{0};

    ifstream calibration_values("../input.txt");

    string line;

    while (getline(calibration_values, line))
    {
        total += find_value(line);
    }

    cout << total;

    return 0;
}