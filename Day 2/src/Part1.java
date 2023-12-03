import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Part1 {
    private static final int redCheck = 12;
    private static final int greenCheck = 13;
    private static final int blueCheck = 14;

    private static final Path filepath = Path.of("input.txt");

    public static void main(String[] args) throws IOException {
        List<String> games = Files.readAllLines(filepath);

        final int size = games.size();
        int sum = (size * (1 + size)) / 2;

        List<List<String>> draws = Parser.parse(games);

        for (int i = 0; i < draws.size(); i++) {
            int red = 0;
            int green = 0;
            int blue = 0;

            for (int j = 0; j < draws.get(i).size(); j++) {
                if ((j + 1) % 2 == 0) {
                    switch (draws.get(i).get(j)) {
                        case "red" ->
                            red = Integer.parseInt(draws.get(i).get(j - 1));
                        case "green" ->
                            green = Integer.parseInt(draws.get(i).get(j - 1));
                        case "blue" ->
                            blue = Integer.parseInt(draws.get(i).get(j - 1));
                    }

                    if (red > redCheck || green > greenCheck || blue > blueCheck) {
                        sum -= (i + 1);
                        break;
                    }
                }
            }
        }

        System.out.println(sum);
    }
}