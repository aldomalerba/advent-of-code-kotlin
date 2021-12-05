package day5

class Part2Strategy : Strategy {

    override fun parse(lines: List<Line>): List<Point> {

        return lines.map {
            when {
                it.isVertical() -> it.verticalPoints()
                it.isHorizontal() -> it.horizontalPoints()
                else -> it.diagonalPoints()
            }
        }.flatten()
    }

}

