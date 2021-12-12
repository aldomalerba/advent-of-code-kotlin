package day9

import adjacently
import toLocations

data class Location(val value: Int, val x: Int, val y : Int)

class SmokeBasin() {

    fun riskLevel(heightmap: List<String>): Int {
        return lowPoints(heightmap).sumOf { it.value + 1 }
    }

    private fun lowPoints(heightmap: List<String>) : List<Location> {

        val locations = heightmap.toLocations()

        return locations.mapNotNull { location ->

                val adjacently = locations.adjacently(location.x,location.y).map { it.value }

                if(location.value < adjacently.minOf { it }) {
                    location
                }else null
        }
    }

    fun basins(heightmap: List<String>): Int {

        val locations = heightmap.toLocations()
        val lowPoints = lowPoints(heightmap)

        val allBasins = lowPoints.map { lowPoint -> basin(locations, lowPoint).distinct() }
        return allBasins.sortedByDescending { it.size }.take(3).fold(1){
                acc, list -> acc * list.size
        }
    }

    private fun basin(heightmap: List<Location>, lowPoint: Location, locations: MutableList<Location> = mutableListOf()) : List<Location> {

        locations.add(lowPoint)
        val adjacents = heightmap.adjacently(lowPoint.x, lowPoint.y).filter { it.value!=9 && !locations.contains(it) }

        return if(adjacents.isEmpty()) locations
        else adjacents.map { basin(heightmap, it, locations) }.flatten()

    }
}