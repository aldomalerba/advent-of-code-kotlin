import da11.DumboOctopus
import java.io.File

fun main() {

    val input = File("src","Day11.txt").readLines().map { it.trim() }
    println("output part 1: " + DumboOctopus().execute(input, 100))
    println("output part 2: " + DumboOctopus().execute(input))
}