class DiagnosticReport {

    fun powerConsumption(numbers: List<String>): Int {
        return gamma(numbers) * epsilon(numbers)
    }

    fun supportRating(numbers: List<String>): Int {
        return 0;
    }

    fun gamma(numbers: List<String>): Int {
         return (0 until numbers.first().count()).map { index -> numbers.mostCommonBitAt(index)!! }.toDecimal()
    }

    fun epsilon(numbers: List<String>): Int {
        return (0 until numbers.first().count()).map{ index -> numbers.leastCommonBitAt(index)!! }.toDecimal()
    }

    private fun List<Char?>.toDecimal() = Integer.parseInt(joinToString(""), 2)

    private fun List<String>.countEachBit(index: Int) = map { it[index] }.groupingBy { it }.eachCount()

    private fun List<String>.mostCommonBitAt(index: Int) = sortedDescending().countEachBit(index).maxByOrNull { it.value }?.key

    private fun List<String>.leastCommonBitAt(index: Int) = countEachBit(index).minByOrNull { it.value }?.key

    fun oxygenGenerator(numbers: List<String>): Int {

        return filterMostCommonBitAt(numbers)
    }

    private fun filterMostCommonBitAt(numbers: List<String>, index: Int = 0) : Int {

        val bit = numbers.mostCommonBitAt(index)
        val filtered = numbers.filter { it[index] == bit }

        if(filtered.size == 1) return Integer.parseInt(filtered.first(), 2)

        return filterMostCommonBitAt(filtered, index + 1)
    }

    fun co2Scrubber(numbers: List<String>): Int {
        return filterLeastCommonBitAt(numbers)
    }

    private fun filterLeastCommonBitAt(numbers: List<String>, index: Int = 0) : Int {

        val bit = numbers.leastCommonBitAt(index)
        val filtered = numbers.filter { it[index] == bit }

        if(filtered.size == 1) return Integer.parseInt(filtered.first(), 2)

        return filterLeastCommonBitAt(filtered, index + 1)
    }

}