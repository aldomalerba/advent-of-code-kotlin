package day13

data class Coordinates(val x: Int, val y:Int)

interface Fold {
    fun fold(coordinates: List<Coordinates>) : List<Coordinates>
}

class TrasparentOrigami {

    fun execute(values: List<String>): Int {

        val randomDots = values.takeWhile { it.isNotEmpty() }.map {
            it.split(",").map { it.toInt() }
        }.map { Coordinates(it.first(), it.last()) }

        val instructions = values.reversed().takeWhile { it.isNotEmpty() }.reversed().map {
            it.split("=")
        }.map {
            val direction = it.first().last()
            val value = it.last().toInt()
            if (direction == 'y') FoldUp(value)
            else FoldLeft(value)
        }

        var folded = randomDots

        instructions.forEach { instruction ->
            folded =  instruction.fold(folded)
        }

        for(row in 0..folded.maxOf { it.y }){

            val valuesInRow = folded.filter { it.y == row }
            var rowToPrint = ""

            for (column in 0..folded.maxOf { it.x }){
                if(valuesInRow.contains(Coordinates(column, row))){
                    rowToPrint += "#"
                }
                else rowToPrint += "."
            }
            println(rowToPrint)
        }

        return instructions.first().fold(randomDots).size

    }

}

class FoldUp(private val height: Int) : Fold {

    override fun fold(coordinates: List<Coordinates>) : List<Coordinates>{
        return coordinates.filter {
            it.y <= height * 2 && it.y != height
        }.map {
            if (it.y < height) it
            else Coordinates(it.x,(height * 2) - it.y )
        }.distinct()
    }

}

class FoldLeft(private val height: Int) : Fold {
    override fun fold(coordinates: List<Coordinates>): List<Coordinates> {

        return coordinates.filter {
            it.x <= height * 2 && it.x != height
        }.map {
            if (it.x < height) it
            else Coordinates((height * 2) - it.x, it.y)
        }.distinct()

    }
}