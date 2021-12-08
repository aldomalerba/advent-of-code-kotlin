import day7.AverageStrategy
import day7.FuelCalculator
import day7.MedianStrategy
import java.io.File

class Day7 {

        fun part1(input: List<String>) =
                FuelCalculator(MedianStrategy()).execute(input.first())

        fun part2(input: List<String>) =
                FuelCalculator(AverageStrategy()).execute(input.first())
}

fun main() {

        val input = File("src","Day7.txt").readLines().map { it.trim() }
        println("output part 1 ${Day7().part1(input)}")
        println("output part 2 ${Day7().part2(input)}")
}
