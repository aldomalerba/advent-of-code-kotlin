package day4

class Day4(val bingo: BingoSubsystem) {

    fun execute(input: List<String>) : Int {
        val numbers = input.first().split(",").map{ it.toInt() }
        val boards = input.drop(1).filter { it.isNotEmpty() }.windowed(5,5).map {
            Board(
                it.map { it.split(" +".toRegex()).map { it.toInt() } }
            )
        }

        bingo.play(numbers, boards)
        return 0
    }

}
