package day4

typealias Row = List<String>
typealias Board = List<Row>

class BingoSubsystem {

    private val winners = mutableListOf<Int>()

    fun play(input: List<String>) : List<Int> {

        val numbers = toNumbers(input)
        var boards = toBoards(input).toMutableList()

        for(number in numbers) {
            boards = boards.map { board -> board.marked(number) }.toMutableList()

            val winBoards = boards.filter { board-> board.containsMarkedRow() || board.pivot().containsMarkedRow() }
            winners.addAll(winBoards.map { it.score(number) })
            boards.removeAll(winBoards)

        }

        return winners
    }

    private fun toNumbers(input: List<String>) = input.first().split(",")

    private fun toBoards(input: List<String>) =
        input.drop(1).filter { it.isNotEmpty() }.windowed(5, 5).map {
            it.map { it.split(" +".toRegex()) }
        }

    private fun Board.containsMarkedRow() = map { it.all { it == "X" } }.any { it }
    private fun Board.pivot() = (indices).map { index -> map { it[index] } }
    private fun Board.score(number: String) = flatten().filter { it != "X" }.sumOf { it.toInt() } * number.toInt()
    private fun Board.marked(number: String) = map { row -> row.map { if (it == number) "X" else it } }

}