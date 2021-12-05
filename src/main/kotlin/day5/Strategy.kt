package day5

interface Strategy {
    fun parse(lines: List<List<Point>>) : List<Point>
}
