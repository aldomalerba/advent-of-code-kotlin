class DiagnosticReport {

    fun powerConsumption(numbers: List<String>): Int {
        return gamma(numbers) * epsilon(numbers)
    }

    fun gamma(numbers: List<String>): Int {
         return forEachBit(numbers) { index -> numbers.mostCommonBitAt(index)!! }.toDecimal()
    }

    fun epsilon(numbers: List<String>): Int {
        return forEachBit(numbers){ index -> numbers.leastCommonBitAt(index)!! }.toDecimal()
    }

    private fun List<Char?>.toDecimal() = Integer.parseInt(joinToString(""), 2)

    private fun List<String>.countEachBit(index: Int) = map { it[index] }.groupingBy { it }.eachCount()

    private fun List<String>.mostCommonBitAt(index: Int) = countEachBit(index).maxByOrNull { it.value }?.key

    private fun List<String>.leastCommonBitAt(index: Int) = countEachBit(index).minByOrNull { it.value }?.key

    private fun forEachBit(numbers: List<String>, mapFunction : List<String>.(Int) -> Char ) : List<Char> {
        return (0 until numbers.first().count()).map { numbers.mapFunction(it) }
    }
}