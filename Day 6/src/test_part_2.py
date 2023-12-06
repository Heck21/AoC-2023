from solver import p2parse, calculate


def main() -> None:
    parsed = p2parse("example")

    total = calculate(parsed)

    assert total == 71503


if __name__ == "__main__":
    main()
