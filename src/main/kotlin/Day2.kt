class Day2(private val submarine: MoveSubmarine) {

    fun execute(commands: List<String>) : Int {

        commands.forEach { command ->
            submarine.execute(command)
        }

        return  submarine.horizontal() * submarine.depth()
    }

}