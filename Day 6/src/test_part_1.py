from solver import p1parse, calculate


def main() -> None:
    parsed = p1parse("example")

    total = calculate(parsed)

    assert total == 288


if __name__ == "__main__":
    main()
