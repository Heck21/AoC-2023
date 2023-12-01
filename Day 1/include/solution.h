#ifndef SOLUTION_H
#define SOLUTION_H

#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <cctype>
#include <cassert>

using namespace std;

int find_value(string line)
{
    vector<char> digits;

    for (auto character : line)
    {
        if (isdigit(character))
        {
            digits.push_back(character);
        }
    }

    if (digits.size() > 0)
    {
        string value;

        value += digits.front();
        value += digits.back();

        return stoi(value);
    }

    return 0;
}

#endif // SOLUTION_H