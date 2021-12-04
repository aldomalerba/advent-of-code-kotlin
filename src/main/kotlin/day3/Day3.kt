package day3

import java.io.File

fun main() {

    val input = File("src","Day3.txt").readLines().map { it.trim() }
    val part1 = DiagnosticReport().powerConsumption(input)
    val part2 = DiagnosticReport().lifeSupport(input)
    println(part1)
    println(part2)

}