import java.io.File
import kotlin.streams.toList

class Day8 {

    private val pattern = mapOf(
        listOf(0,1,2,3,4,5) to '0',
        listOf(0,1,3,4,6) to '2',
        listOf(0,1,2,3,6) to '3',
        listOf(0,2,3,5,6) to '5',
        listOf(0,2,3,4,5,6) to '6',
        listOf(0,1,2,3,5,6) to '9'
    )



    fun part1(input: List<String>): Int {
        val allDigits = input.map { it.split("|").last().trim().split(" ") }
        return allDigits.map { it.filter { listOf(2,3,4,7).contains(it.length) } }.flatten().count()
    }

    fun part2(input: List<String>): Int {

        return input.sumOf {
            val displayNumbers = it.split("|").first().trim().split(" ")
            val allDigits = it.split("|").last().trim().split(" ")

            val segments = segmentConfiguration(displayNumbers)
            displayValue(allDigits, segments)
        }

    }

    private fun displayValue(allDigits: List<String>, segments: Array<Char>): Int {
        return allDigits.map {
            when (it.length) {
                2 -> '1'
                3 -> '7'
                4 -> '4'
                7 -> '8'
                else -> pattern.getValue(it.map { segments.indexOf(it) }.sorted())
            }
        }.joinToString("").toInt()
    }

    private fun segmentConfiguration(displayNumbers: List<String>): Array<Char> {
        val segments = Array(7) { ' ' }
        val one = displayNumbers.find { it.length == 2 }!!
        segments[1] = one[0]
        segments[2] = one[1]

        val seven = displayNumbers.find { it.length == 3 }!!
        segments[0] = seven.filter { !one.contains(it) }[0]

        val four = displayNumbers.find { it.length == 4 }!!
        segments[5] = four.filter { !one.contains(it) }[0]
        segments[6] = four.filter { !one.contains(it) }[1]

        val nine = displayNumbers.filter { it.length == 6 }.find {
            it.toList().containsAll(listOf(segments[1], segments[2], segments[5], segments[6]))
        }!!

        segments[3] = nine.filter { !segments.contains(it) && it != ' ' }[0]

        val three = displayNumbers.filter { it.length == 5 }.find {
            it.toList().containsAll(listOf(segments[0], segments[1], segments[2], segments[3]))
        }!!

        if (three.contains(segments[5])) {
            val tmp = segments[5]
            segments[5] = segments[6]
            segments[6] = tmp
        }

        val five = displayNumbers.filter { it.length == 5 }.find {
            it.toList().containsAll(listOf(segments[0], segments[5], segments[6], segments[3]))
        }!!

        if (five.contains(segments[1])) {
            val tmp = segments[1]
            segments[1] = segments[2]
            segments[2] = tmp
        }

        val eight = displayNumbers.find { it.length == 7 }!!
        segments[4] = eight.filter { !segments.contains(it) }[0]
        return segments
    }

}

fun main() {

    val input = File("src","Day8.txt").readLines().map { it.trim() }
    println("output part 1 ${Day8().part1(input)}")
    println("output part 2 ${Day8().part2(input)}")
}

