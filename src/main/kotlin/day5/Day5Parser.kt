package day5

class Day5Parser {

    fun points(vents: List<String>)  :List<Point>{
        val parsesVents = vents.map {
            it.split("->").map { it.trim() }.map {
                val coordinate = it.split(",").map { it.toInt() }
                Point(coordinate.first(), coordinate.last())
            }
        }.filter { it.first().x == it.last().x || it.first().y == it.last().y }

        return parsesVents.map {
            if(it.first().y == it.last().y) {
                val points = it.sortedBy { it.x }
                (points.first().x..points.last().x).map { Point(it, points.first().y) }
            }else{
                val points = it.sortedBy { it.y }
                (points.first().y..points.last().y).map { Point(points.first().x, it) }
            }
        }.flatten()
    }

}
