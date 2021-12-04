package day2

class Submarine : MoveSubmarine {

    private var horizontal = 0
    private var depth = 0

    override fun execute(direction: String, steps: Int) {

        when (direction) {
            "forward" -> horizontal += steps
            "up" -> depth -= steps
            else -> depth += steps
        }
    }

    override fun horizontal() = horizontal

    override fun depth() = depth

}
