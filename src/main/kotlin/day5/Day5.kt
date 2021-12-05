package day5
import java.io.File


fun main() {

    val input = File("src","Day5.txt").readLines().map { it.trim() }
    val result = HydrothermalVents(Day5Parser()).execute(input)
    println("output part 1 $result")
}