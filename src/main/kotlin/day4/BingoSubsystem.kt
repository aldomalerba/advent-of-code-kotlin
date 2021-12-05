package day4

typealias Row = List<String>
typealias Board = List<Row>

class BingoSubsystem {

    private val winners = mutableListOf<Int>()

    fun play(input: List<String>) : List<Int> {

        val numbers = input.first().split(",")
        var boards = input.asSequence().drop(1).filter { it.isNotEmpty() }.windowed(5,5).map {
            it.map { it.split(" +".toRegex()) }
        }.toMutableList()

        for(number in numbers) {
            boards = boards.map { board -> board.map{ row -> row.map { if(it==number) "X" else it  } } }.toMutableList()

            val winBoards = boards.filter { board-> anyMarkedRow(board) || anyMarkedRow(board.pivot()) }
            winners.addAll(winBoards.map { it.score(number) })
            boards.removeAll(winBoards)

        }

        return winners
    }

    private fun anyMarkedRow(board: List<List<String>>) =
        board.map { it.all { it == "X" } }.any { it }

    private fun Board.pivot() = (indices).map { index -> map { it[index] } }
    private fun Board.score(number: String) = flatten().filter { it != "X" }.sumOf { it.toInt() } * number.toInt()

}