class Day2(private val submarine: MoveSubmarine) {

    fun execute(commands: List<String>) : Int {

        commands.forEach { command ->
            submarine.execute(command.direction(), command.steps())
        }
        return  submarine.horizontal() * submarine.depth()
    }

    private fun String.steps() = split(" ").last().toInt()
    private fun String.direction() = split(" ").first()

}
