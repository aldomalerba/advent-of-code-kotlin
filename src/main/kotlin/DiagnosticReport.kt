import kotlin.streams.toList

class DiagnosticReport {

    fun powerConsumption(numbers: List<String>): Int {
        TODO("Not yet implemented")
    }

    fun gamma(numbers: List<String>): Int {

         val binaryGamma = (0 until 5).map { index -> numbers.map{ it[index].toString() }.groupingBy { it }.eachCount().maxByOrNull { it.value }?.key }
         return Integer.parseInt(binaryGamma.joinToString(""), 2)
    }

    fun epsilon(numbers: List<String>): Int {
        val binaryGamma = (0 until 5).map { index -> numbers.map{ it[index].toString() }.groupingBy { it }.eachCount().minByOrNull { it.value }?.key }
        return Integer.parseInt(binaryGamma.joinToString(""), 2)
    }

}
