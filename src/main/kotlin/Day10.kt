import day10.SyntaxScoring
import java.io.File

fun main() {

    val input = File("src","Day10.txt").readLines().map { it.trim() }
    println("output part 1: " + SyntaxScoring().score(input))
    println("output part 2: " + SyntaxScoring().middleScore(input))
}