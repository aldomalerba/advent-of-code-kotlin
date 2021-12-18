import day14.ExtendedPolymerization
import java.io.File

fun main() {

    fun part1(input: List<String>) : Int{
        return ExtendedPolymerization().execute(input, 40)
    }

    val input = File("src","Day14.txt").readLines().map { it.trim() }
    println("output part 1: " + part1(input))

}