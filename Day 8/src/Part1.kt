import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.readLines

fun steps(file: Path): Int {
    var lines = file.readLines()
    val directions = lines.first().toCharArray()

    val source = "AAA"
    val destination = "ZZZ"

    var steps = 0

    var found = false

    val map: MutableMap<String, Pair<String, String>> = mutableMapOf()

    lines = lines.drop(2)

    for (line in lines) {
        val (node, element) = line.split(" = ")
        val (left, right) = element
            .removeSurrounding("(", ")")
            .split(", ")

        map[node] = Pair(left, right)
    }

    while (!found) {
        var current = map[source]

        for (i in 0..Int.MAX_VALUE) {
            when (directions[i % directions.size]) {
                'L' -> {
                    steps++
                    if (current?.first == destination) {
                        found = true
                        break
                    } else {
                        current = map[current?.first]
                    }
                }

                'R' -> {
                    steps++
                    if (current?.second == destination) {
                        found = true
                        break
                    } else {
                        current = map[current?.second]
                    }
                }
            }
        }
    }

    return steps
}


fun main() {
    val file = Path("input.txt")

    println(steps(file))
}