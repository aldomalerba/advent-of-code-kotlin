package day5

interface Strategy {
    fun parse(lines: List<Line>) : List<Point>
}
