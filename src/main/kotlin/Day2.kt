import java.io.File

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

fun main() {

    val input = File("src","Day2.txt").readLines().map { it.trim() }
    println("output part 1: ${Day2(Submarine()).execute(input)}")
    println("output part 2: ${Day2(AimSubmarine()).execute(input)}")

}
