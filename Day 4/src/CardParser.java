import java.util.ArrayList;
import java.util.List;

public class CardParser {
    public static List<List<String>> parse(List<String> card) {
        List<List<String>> parsedCard = new ArrayList<>();

        for (var game : card) {
            int colon = game.indexOf(":");

            String[] parsedGame = game.substring(colon + 1)
                                      .stripLeading()
                                      .split("\\|");

            parsedCard.add(List.of(parsedGame));
        }

        return parsedCard;
    }

    public static int calculate(List<String> parsedCard) {
        String[] winningNumbers = parsedCard.get(0)
                                            .trim()
                                            .replaceAll("\\s+", " ")
                                            .split(" ");
        String[] numbers = parsedCard.get(1)
                                     .trim()
                                     .replaceAll("\\s+", " ")
                                     .split(" ");

        List<String> matchedNumbers = new ArrayList<>();

        for (var winningNumber : winningNumbers) {
            for (var number : numbers) {
                if (winningNumber.equals(number)) {
                    matchedNumbers.add(number);
                }
            }
        }

        if (!matchedNumbers.isEmpty()) {
            int points = 1;

            for (var x : matchedNumbers) {
                points *= 2;
            }

            return points / 2;
        }

        return 0;
    }
}