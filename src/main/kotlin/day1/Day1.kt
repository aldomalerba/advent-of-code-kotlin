package day1

import java.io.File

class Day1 {

    fun execute(measurements: List<String>, slicingSize: Int): Int {
        measurements.map { it.toInt() }.grouped(slicingSize).let {
            return it.increasingValues().size
        }
    }

    private fun List<Int>.grouped(slicingSize: Int) = windowed(slicingSize).map { it.sum() }
    private fun List<Int>.increasingValues() = drop(1).filterIndexed { index, item -> item > this[index] }
}

fun main() {

    val input = File("src","Day1.txt").readLines().map { it.trim() }
    println("output part 1: ${Day1().execute(input, 1)}")
    println("output part 2: ${Day1().execute(input, 3)}")

}