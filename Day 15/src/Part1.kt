import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.readLines

fun hash(step: CharArray): Int {
    var current = 0

    for (char in step) {
        val code = char.code
        current += code
        current *= 17
        current %= 256
    }

    return current
}


fun calculate(file: Path): Int {
    var total = 0

    val steps: MutableList<CharArray> = mutableListOf()

    var lines = file.readLines()

    for (line in lines) {
        lines = line.split(",")
    }

    for (step in lines) {
        steps.add(step.toCharArray())
    }

    for (step in steps) {
        total += hash(step)
    }

    return total
}

fun main() {
    val file = Path("input.txt")

    println(calculate(file))
}