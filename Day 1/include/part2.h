#ifndef PART_2_H
#define PART_2_H
#pragma once

#include <string>
#include <vector>
#include <map>
#include <cctype>

using namespace std;

vector<string> values = {
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
};

int find_value(string &line)
{
    vector<int> digits;
    string buffer;

    for (auto &character : line)
    {
        if (!isdigit(character))
        {
            buffer += character;

            for (size_t i = 0; i < values.size(); i++)
            {
                if (buffer.contains(values[i]))
                {
                    digits.push_back(i + 1);
                    buffer = "";
                    break;
                }
            }
        }

        if (isdigit(character))
        {
            digits.push_back(character - '0');
        }
    }

    if (digits.size() > 0)
    {
        int value{0};

        value += digits.front() * 10;
        value += digits.back();

        return value;
    }

    return 0;
}

#endif // PART_2_H