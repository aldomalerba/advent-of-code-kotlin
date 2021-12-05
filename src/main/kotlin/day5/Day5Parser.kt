package day5

class Day5Parser(private val strategy : Strategy) {

    fun points(vents: List<String>)  :List<Point>{

        val parseLines = vents.map {

            val points = it.split("->").map { it.trim() }.map {
                val coordinate = it.split(",").map { it.toInt() }
                Point(coordinate.first(), coordinate.last())
            }

            Line(points.first(), points.last())
        }

        return strategy.parse(parseLines)
    }

}