from itertools import pairwise


def value(file: str) -> int:
    sum = 0

    with open(f"Day 9\\{file}.txt") as f:
        lines = f.readlines()

        all_numbers: list[list[list[int]]] = []

        for line in lines:
            numbers: list[list[int]] = []

            line = [int(x) for x in line.split(" ")]

            numbers.append(line)

            while True:
                line = [y - x for x, y in pairwise(line)]

                numbers.append(line)

                if set(line) == {0}:
                    all_numbers.append(numbers)
                    break

        for numbers in all_numbers:
            numbers.reverse()

            for idx, nums in enumerate(numbers):
                nums.append(0)

                if idx == 0:
                    continue

                nums[-1] = nums[-2] + numbers[idx - 1][-1]

            sum += numbers[-1][-1]

    return sum


def main() -> None:
    print(value("input"))


if __name__ == "__main__":
    main()
