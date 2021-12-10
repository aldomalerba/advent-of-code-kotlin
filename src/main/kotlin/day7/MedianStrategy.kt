package day7

import kotlin.math.absoluteValue

class MedianStrategy : Strategy{
    override fun calculate(values: List<Int>): Int {
        val sorted = values.sorted()
        val median = sorted.size/2
        return sorted.map { (it-sorted[median]).absoluteValue }.sumOf{ it }
    }

}