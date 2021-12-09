package day9

data class Location(val value: Char?, val x: Int, val y : Int)

class SmokeBasin() {

    fun riskLevel(heightmap: List<String>): Int {
        return lowPoints(heightmap).sumOf { Character.getNumericValue(it.value!!) + 1 }
    }

    private fun lowPoints(heightmap: List<String>) = heightmap.mapIndexedNotNull { indexRow, row ->

        row.mapIndexedNotNull{ indexColumn, char ->

            val adjacently = heightmap.adjacently(indexColumn,indexRow).map { it.value }

            if(Character.getNumericValue(char) < adjacently.minOf { Character.getNumericValue(it!!) }) {
                Location(char, indexColumn, indexRow)
            }else null

        }

    }.flatten()

    fun basins(heightmap: List<String>): Int {
        val lowPoints = lowPoints(heightmap)

        val allBasins = lowPoints.map { lowPoint -> basin(heightmap, lowPoint).distinct() }
        return allBasins.sortedByDescending { it.size }.take(3).fold(1){
                acc, list -> acc * list.size
        }
    }

    private fun basin(heightmap: List<String>, lowPoint: Location, locations: MutableList<Location> = mutableListOf()) : List<Location> {

        locations.add(lowPoint)
        val adjacents = heightmap.adjacently(lowPoint.x, lowPoint.y).filter { it.value!='9' && !locations.contains(it) }

        return if(adjacents.count() == 0) locations
        else adjacents.map { basin(heightmap, it, locations) }.flatten()

    }

    private fun List<String>.location(x: Int, y: Int) =  if(getOrNull(y)?.getOrNull(x)!=null) Location(getOrNull(y)?.get(x), x, y) else null

    private fun List<String>.adjacently(x: Int, y: Int,): List<Location> {
        val top = location(x, y-1)
        val down = location(x, y+1)
        val left = location(x-1, y)
        val right = location(x+1,y)
        return listOfNotNull(top, down, left, right)
    }

}