package day7

import kotlin.math.absoluteValue
import kotlin.math.ceil
import kotlin.math.floor

class AverageStrategy : Strategy {
    override fun calculate(values: List<Int>): Int {
        val average = weightedAverage(values)

        return minOf(
            values.fuel(ceil(average)),
            values.fuel(floor(average))
        )
    }

    private fun weightedAverage(values: List<Int>) =
        values.groupingBy { it }.eachCount().map { it.key * it.value }.sum().toDouble() / values.size

    private fun List<Int>.fuel(average: Double) =
        map { List((it - average.toInt()).absoluteValue) { i -> i + 1 } }.flatten().sumOf { it }

}
