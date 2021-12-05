package day5


class Part1Strategy : Strategy {

    override fun parse(lines: List<List<Point>>): List<Point> {

        return lines.filter { isHorizontal(it) || isVertical(it) }.map {
            when{
                isVertical(it) -> verticalPoints(it)
                else -> horizontalPoints(it)
            }
        }.flatten()
    }

    private fun horizontalPoints(it: List<Point>): List<Point> {
        val points = it.sortedBy { it.y }
        return (points.first().y..points.last().y).map { Point(points.first().x, it) }
    }

    private fun verticalPoints(it: List<Point>): List<Point> {
        val points = it.sortedBy { it.x }
        return (points.first().x..points.last().x).map { Point(it, points.first().y) }
    }

    private fun isVertical(it: List<Point>) = it.first().y == it.last().y
    private fun isHorizontal(it: List<Point>) = it.first().x == it.last().x

}
