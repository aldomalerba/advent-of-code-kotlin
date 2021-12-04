package day3

class DiagnosticReport {

    fun powerConsumption(numbers: List<String>): Int {
        return gamma(numbers) * epsilon(numbers)
    }

    fun lifeSupport(numbers: List<String>): Int {
        return co2Scrubber(numbers) * oxygenGenerator(numbers)
    }

    fun gamma(numbers: List<String>): Int {
        return List(numbers.first().count()) { i -> numbers.mostCommonBitAt(i) }.toDecimal()
    }

    fun epsilon(numbers: List<String>): Int {
        return List(numbers.first().count()) { i -> numbers.leastCommonBitAt(i) }.toDecimal()
    }

    fun oxygenGenerator(numbers: List<String>, index: Int = 0): Int {

        val bit = numbers.mostCommonBitAt(index)
        val filtered = numbers.filter { it[index] == bit }

        if (filtered.size == 1) return Integer.parseInt(filtered.first(), 2)

        return oxygenGenerator(filtered, index + 1)

    }

    fun co2Scrubber(numbers: List<String>, index: Int = 0): Int {

        val bit = numbers.leastCommonBitAt(index)
        val filtered = numbers.filter { it[index] == bit }

        if (filtered.size == 1) return Integer.parseInt(filtered.first(), 2)

        return co2Scrubber(filtered, index + 1)
    }


    private fun List<Char?>.toDecimal() = Integer.parseInt(joinToString(""), 2)

    private fun List<String>.countEachBitAt(index: Int) = map { it[index] }.groupingBy { it }.eachCount()

    private fun List<String>.mostCommonBitAt(index: Int) = sortedDescending().countEachBitAt(index).maxByOrNull { it.value }?.key

    private fun List<String>.leastCommonBitAt(index: Int) = sorted().countEachBitAt(index).minByOrNull { it.value }?.key

}