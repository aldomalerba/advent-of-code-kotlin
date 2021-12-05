package day5

class HydrothermalVents(private val parser: Day5Parser) {
    fun execute(vents: List<String>): Int {
        val points = parser.points(vents)
        return points.groupingBy { it }.eachCount().filter { it.value > 1 }.size;
    }

}
