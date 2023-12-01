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

    for (auto line : lines)
    {
        total += find_value(line);
    }

    assert(total == 142);
}

int main(void)
{
    // test();

    int total{0};

    ifstream calibration_values("input.txt");

    string line;

    while (getline(calibration_values, line))
    {
        total += find_value(line);
    }

    cout << total;

    return 0;
}