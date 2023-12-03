import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example {
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

        final int redCheck = 12;
        final int greenCheck = 13;
        final int blueCheck = 14;

        int idSum = (games.size() * (1 + 100)) / 2;

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

        for (var draw : draws) {
            System.out.println(Arrays.toString(draw));
        }

        for (int i = 0; i < draws.size(); i++) {
            int red = 0;
            int green = 0;
            int blue = 0;

            for (int j = 0; j < draws.get(i).length; j++) {
                if ((j + 1) % 2 == 0) {
                    switch (draws.get(i)[j]) {
                        case "red" ->
                            red = Integer.parseInt(draws.get(i)[j - 1]);
                        case "green" ->
                            green = Integer.parseInt(draws.get(i)[j - 1]);
                        case "blue" ->
                            blue = Integer.parseInt(draws.get(i)[j - 1]);
                    }

                    if (red > redCheck || green > greenCheck || blue > blueCheck) {
                        idSum -= (i + 1);
                        break;
                    }
                }
            }
        }

        System.out.println(idSum);
    }
}