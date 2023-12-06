from typing import NamedTuple


class Values(NamedTuple):
    time: int
    distance: int


def p1parse(file: str) -> list[Values]:
    data: list[Values] = []

    with open(f"Day 6\\{file}.txt") as f:
        lines = f.readlines()

        for i, line in enumerate(lines):
            line = " ".join(lines[i].split())

            space = line.find(" ") + 1
            line = line[space:]

            colon = line.find(":") + 1
            line = line[colon:]

            line = line.split(" ")

            lines[i] = line

        times = lines[0]
        distances = lines[1]

        for time, distance in zip(times, distances):
            record = Values(int(time), int(distance))

            data.append(record)

    return data


def p2parse(file: str) -> list[Values]:
    data: list[Values] = []

    with open(f"Day 6\\{file}.txt") as f:
        lines = f.readlines()

        for i, line in enumerate(lines):
            line = "".join(lines[i].split())

            space = line.find(" ") + 1
            line = line[space:]

            colon = line.find(":") + 1
            line = line[colon:]

            line = line.split(" ")

            lines[i] = line

        times = lines[0]
        distances = lines[1]

        for time, distance in zip(times, distances):
            record = Values(int(time), int(distance))

            data.append(record)

    return data


def calculate(data: list[Values]) -> int:
    wins: list[list[int]] = []
    total = 1

    for race in data:
        values: list[int] = []
        time, distance = race.time, race.distance

        for hold in range(1, time + 1):
            if ((time - hold) * hold) > distance:
                values.append(hold)

        wins.append(values)

    for win in wins:
        total *= len(win)

    return total
