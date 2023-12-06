from solver import p1parse, calculate


def main() -> None:
    parsed = p1parse("input")

    total = calculate(parsed)

    print(total)


if __name__ == "__main__":
    main()
