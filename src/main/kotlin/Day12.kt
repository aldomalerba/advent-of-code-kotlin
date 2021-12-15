import day12.Part1Strategy
import day12.Part2Strategy
import day12.PassagePathing
import java.io.File

fun part1(input: List<String>) : Int{
    return PassagePathing(Part1Strategy()).execute(input)
        .count { it.filter { it!="start" && it!="end" }.any { it.all { it.isLowerCase() } } }
}

fun part2(input: List<String>) : Int{
    return PassagePathing(Part2Strategy()).execute(input).size
}

fun main() {

    val input = File("src","Day12.txt").readLines().map { it.trim() }
    println("output part 1: " + part1(input))
    println("output part 2: " + part2(input))
}