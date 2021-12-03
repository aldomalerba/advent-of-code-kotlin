import java.io.File

class Day3(private val report: DiagnosticReport) {

    fun execute(numbers: List<String>): Int {
        return report.powerConsumption(numbers)
    }

}


fun main() {

    val input = File("src","Day2.txt").readLines().map { it.trim() }
    
}