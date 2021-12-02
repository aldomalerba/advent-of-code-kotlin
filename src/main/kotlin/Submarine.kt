class Submarine : MoveSubmarine {

    private var horizontal = 0
    private var depth = 0

    override fun execute(command: String) {

        when (command.direction()) {
            "forward" -> horizontal += command.steps()
            "up" -> depth -= command.steps()
            else -> depth += command.steps()
        }
    }

    private fun String.steps() = split(" ").last().toInt()

    private fun String.direction() = split(" ").first()

    override fun horizontal(): Int {
        return horizontal;
    }

    override fun depth(): Int {
        return depth
    }

}
