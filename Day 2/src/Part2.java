import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Part2 {
    public static void main(String[] args) throws IOException {
//        String[] games = {
//            "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
//            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
//            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
//            "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
//            "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
//        };

        List<String> games = Files.readAllLines(Path.of("input.txt"));

        List<String[]> draws = new ArrayList<>();

        int sum = 0;

        for (var game : games) {
            int colon = game.indexOf(":");

            String[] draw = game
                .substring(colon + 1)
                .stripLeading()
                .replace(";", "")
                .replace(",", "")
                .split(" ");

            draws.add(draw);
        }

        for (int i = 0; i < draws.size(); i++) {
            List<Integer> redList = new ArrayList<>();
            List<Integer> greenList = new ArrayList<>();
            List<Integer> blueList = new ArrayList<>();

            for (int j = 0; j < draws.get(i).length; j++) {
                if ((j + 1) % 2 == 0) {
                    switch (draws.get(i)[j]) {
                        case "red" ->
                            redList.add(Integer.parseInt(draws.get(i)[j - 1]));
                        case "green" -> greenList.add(
                            Integer.parseInt(draws.get(i)[j - 1]));
                        case "blue" ->
                            blueList.add(Integer.parseInt(draws.get(i)[j - 1]));
                    }
                }
            }

            int maxRed = Collections.max(redList);
            int maxGreen = Collections.max(greenList);
            int maxBlue = Collections.max(blueList);

            int setPower = maxRed * maxGreen * maxBlue;

            sum += setPower;
        }

        System.out.println(sum);
    }
}