package day5
import java.io.File


fun main() {

    val input = File("src","Day5.txt").readLines().map { it.trim() }
    val part1 = HydrothermalVents(Day5Parser(Part1Strategy())).execute(input)
    val part2 = HydrothermalVents(Day5Parser(Part2Strategy())).execute(input)
    println("output part 1 $part1")
    println("output part 2 $part2")
}