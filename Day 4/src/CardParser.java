import java.util.ArrayList;
import java.util.List;

public class CardParser {
    public static List<List<String>> parse(List<String> cards) {
        List<List<String>> parsedCards = new ArrayList<>();

        for (var card : cards) {
            int colon = card.indexOf(":");

            String[] parsedCard = card.substring(colon + 1)
                                      .stripLeading()
                                      .split("\\|");

            parsedCards.add(List.of(parsedCard));
        }

        return parsedCards;
    }

    public static List<String> getMatches(List<String> parsedCard) {
        String[] winningNumbers = parsedCard.get(0)
                                            .trim()
                                            .replaceAll("\\s+", " ")
                                            .split(" ");

        String[] ownNumbers = parsedCard.get(1)
                                        .trim()
                                        .replaceAll("\\s+", " ")
                                        .split(" ");

        List<String> matches = new ArrayList<>();

        for (var winningNumber : winningNumbers) {
            for (var ownNumber : ownNumbers) {
                if (winningNumber.equals(ownNumber)) {
                    matches.add(ownNumber);
                }
            }
        }

        return matches;
    }

    public static int getPoints(List<String> matches) {
        if (!matches.isEmpty()) {
            int points = 1;

            for (var x : matches) {
                points *= 2;
            }

            return points / 2;
        }

        return 0;
    }
}