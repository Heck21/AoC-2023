import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Part1 {
    private static final Path filepath = Path.of("input.txt");

    public static void main(String[] args) throws IOException {
        List<String> cards = Files.readAllLines(filepath);

        int totalPoints = 0;

        List<List<String>> parsedCards = CardParser.parse(cards);

        for (var x : parsedCards) {
            totalPoints += CardParser.calculate(x);
        }

        System.out.println(totalPoints);
    }
}