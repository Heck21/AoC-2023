#ifndef PART_1_H
#define PART_1_H
#pragma once

#include <string>
#include <vector>
#include <cctype>

using namespace std;

int find_value(string &line)
{
    vector<char> digits;

    for (auto &character : line)
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

#endif // PART_1_H