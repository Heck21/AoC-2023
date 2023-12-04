import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Part2 {
    private static final Path filepath = Path.of("input.txt");

    public static void main(String[] args) throws IOException {
        List<String> cards = Files.readAllLines(filepath);

        List<List<String>> parsedCards = CardParser.parse(cards);

        int[] numberOfCards = new int[cards.size()];
        Arrays.fill(numberOfCards, 1);

        for (int i = 0; i < cards.size(); i++) {
            List<String> matches = CardParser.getMatches(parsedCards.get(i));

            for (int j = matches.size(); j > 0; j--) {
                numberOfCards[i + j] += numberOfCards[i];
            }
        }

        int totalCards = Arrays.stream(numberOfCards).sum();

        System.out.println(totalCards);
    }
}