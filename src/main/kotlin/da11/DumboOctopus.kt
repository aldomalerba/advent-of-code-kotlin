package da11

import allAdjacently
import day9.Location
import toLocations

class DumboOctopus {
    fun execute(values: List<String>, steps: Int): Int {

        var result = values.toLocations().toMutableList()
        var countFlashes = 0
        repeat(steps){

            result.replaceAll {  it -> Location(it.value +1, it.x, it. y) }
            result = flashes(result)
            countFlashes += result.count { it.value == 0 }
        }

        return countFlashes;
    }

    fun execute(values: List<String>): Int {

        var result = values.toLocations().toMutableList()
        var countFlashes = 0
        var step = 0
        while(countFlashes!==100){
            step++
            result.replaceAll {  it -> Location(it.value +1, it.x, it. y) }
            result = flashes(result)
            countFlashes = result.count { it.value == 0 }
        }

        return step;
    }

    private fun flashes(locations: MutableList<Location>, oldFlashes: List<Location> = emptyList() ) : MutableList<Location> {

        val flashes = locations.filter { l -> l.value > 9 && !oldFlashes.any { it.x==l.x && it.y==l.y } }
        locations.replaceAll { if(it.value>9) Location(0, it.x, it.y) else it }
        if(flashes.isEmpty()) return locations
        val allAdjacents = flashes.map { locations.allAdjacently(it.x, it.y).filter { it.value != 0 } }
        val groupedAdjacents = allAdjacents.flatten().groupingBy { it }.eachCount()
        val increased = groupedAdjacents.map { Location(it.key.value + it.value, it.key.x, it.key.y) }
        increased.forEach {
            location ->
            val index = locations.indexOfFirst { it.x == location.x && it.y == location.y }
            locations[index] = location
        }

        return flashes(locations, flashes)
    }

}
