#ifndef PART_2_H
#define PART_2_H
#pragma once

#include <string>
#include <vector>
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
        if (isdigit(character))
        {
            digits.push_back(character - '0');
            buffer.clear();
        }
        else
        {
            buffer += character;

            for (size_t i = 0; i < values.size(); i++)
            {
                if (buffer.contains(values[i]))
                {
                    char last = buffer.back();

                    digits.push_back(i + 1);

                    buffer = last;
                    break;
                }
            }
        }
    }

    if (digits.size() > 0)
    {
        int value = digits.front() * 10 + digits.back();

        return value;
    }

    return 0;
}

#endif // PART_2_H