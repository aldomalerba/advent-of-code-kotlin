import day9.SmokeBasin
import java.io.File

fun main() {

    val input = File("src","Day9.txt").readLines().map { it.trim() }
    println("output part 1 ${SmokeBasin().riskLevel(input)}")
    println("output part 2 ${SmokeBasin().basins(input)}")
}
