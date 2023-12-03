import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static List<List<String>> parse(List<String> data) {
        List<List<String>> parsedData = new ArrayList<>();

        for (var record : data) {
            int colon = data.indexOf(":");

            String[] parsedRecord = record
                .substring(colon + 1)
                .stripLeading()
                .replace(";", "")
                .replace(",", "")
                .split(" ");

            parsedData.add(List.of(parsedRecord));
        }

        return parsedData;
    }
}