package day5


class Part1Strategy : Strategy {

    override fun parse(lines: List<Line>): List<Point> {

        return lines.filter { it.isHorizontal() || it.isVertical() }.map {
            when{
                it.isVertical() -> it.verticalPoints()
                else -> it.horizontalPoints()
            }
        }.flatten()
    }

}
