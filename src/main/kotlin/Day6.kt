import day6.LanternFish
import java.io.File

class Day6 {

        fun part1(input: List<String>) = LanternFish().execute(input.first(), 80)

        fun part2(input: List<String>) = LanternFish().execute(input.first(), 256)

}

fun main() {

        val input = File("src","Day6.txt").readLines().map { it.trim() }
        println("output part 1 ${Day6().part1(input)}")
        println("output part 2 ${Day6().part2(input)}")
}
