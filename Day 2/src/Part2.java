import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Part2 {
    private static final Path filepath = Path.of("input.txt");

    public static void main(String[] args) throws IOException {
        List<String> games = Files.readAllLines(filepath);

        int sumOfPowers = 0;

        List<List<String>> draws = Parser.parse(games);

        for (var draw : draws) {
            List<Integer> redList = new ArrayList<>();
            List<Integer> greenList = new ArrayList<>();
            List<Integer> blueList = new ArrayList<>();

            for (int i = 0; i < draw.size(); i++) {
                if ((i + 1) % 2 == 0) {
                    switch (draw.get(i)) {
                        case "red" ->
                            redList.add(Integer.parseInt(draw.get(i - 1)));
                        case "green" ->
                            greenList.add(Integer.parseInt(draw.get(i - 1)));
                        case "blue" ->
                            blueList.add(Integer.parseInt(draw.get(i - 1)));
                    }
                }
            }

            int maxRed = Collections.max(redList);
            int maxGreen = Collections.max(greenList);
            int maxBlue = Collections.max(blueList);

            int setPower = maxRed * maxGreen * maxBlue;

            sumOfPowers += setPower;
        }

        System.out.println(sumOfPowers);
    }
}