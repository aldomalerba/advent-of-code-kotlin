package day5

class Day5Parser(private val strategy : Strategy) {

    fun points(vents: List<String>)  :List<Point>{

        val parsesVents = vents.map {
            it.split("->").map { it.trim() }.map {
                val coordinate = it.split(",").map { it.toInt() }
                Point(coordinate.first(), coordinate.last())
            }
        }

        return strategy.parse(parsesVents)
    }

}