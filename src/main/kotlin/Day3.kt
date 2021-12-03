import java.io.File

class Day3(private val report: DiagnosticReport) {

    fun execute(numbers: List<String>): Int {
        return report.powerConsumption(numbers)
    }

}


fun main() {

    val input = File("src","Day3.txt").readLines().map { it.trim() }
    val output = Day3(DiagnosticReport()).execute(input)
    println(output)

}