from solver import p2parse, calculate


def main() -> None:
    parsed = p2parse("input")

    total = calculate(parsed)

    print(total)


if __name__ == "__main__":
    main()
