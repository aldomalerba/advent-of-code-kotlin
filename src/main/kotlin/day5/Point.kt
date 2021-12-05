package day5

data class Point(val x: Int, val  y: Int)

data class Line(val point1: Point, val point2: Point ){

    fun horizontalPoints(): List<Point> {
        val points = listOf(point1, point2).sortedBy{ it.y }
        return (points.first().y..points.last().y).map { Point(points.first().x, it) }
    }

    fun verticalPoints(): List<Point> {
        val points = listOf(point1, point2).sortedBy { it.x }
        return (points.first().x..points.last().x).map { Point(it, points.first().y) }
    }


    fun diagonalPoints(): List<Point> {
        val points = listOf(point1, point2).sortedBy { it.x }
        return (points.first().x..points.last().x).mapIndexed { index, x  ->
            val y = if(points.first().y > points.last().y) points.first().y - index else points.first().y + index
            Point(x, y)
        }
    }

    fun isVertical() = point1.y == point2.y
    fun isHorizontal() = point1.x == point2.x
}