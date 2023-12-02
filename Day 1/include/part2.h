// Doesn't work all the time.
// Will fix at a later date.

#ifndef PART_2_H
#define PART_2_H
#pragma once

#include <string>
#include <vector>
#include <map>
#include <cctype>
#include <regex>

using namespace std;

map<string, char> values = {
    {"one", '1'},
    {"two", '2'},
    {"three", '3'},
    {"four", '4'},
    {"five", '5'},
    {"six", '6'},
    {"seven", '7'},
    {"eight", '8'},
    {"nine", '9'},
};

int find_value(string &line)
{
    vector<char> digits;
    string buffer;

    for (auto &character : line)
    {
        if (!isdigit(character))
        {
            buffer += character;

            if (values.contains(buffer))
            {
                digits.push_back(values[buffer]);
                buffer = "";
            }
        }

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

#endif // PART_2_H