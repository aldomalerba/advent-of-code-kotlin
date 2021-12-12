
import day9.Location
import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt").readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)

/**
 * Converts List<String> to List<List<Location>>
 */

fun List<String>.toLocations() =
    mapIndexed{ row, it -> it.mapIndexed { column, char -> Location(Character.getNumericValue(char!!),column, row) }}.flatten()

private fun List<Location>.location(x: Int, y: Int) =  find { it.x == x && it.y == y }

fun List<Location>.adjacently(x: Int, y: Int,): List<Location> {
    val top = location(x, y-1)
    val down = location(x, y+1)
    val left = location(x-1, y)
    val right = location(x+1,y)
    return listOfNotNull(top, down, left, right)
}

fun List<Location>.allAdjacently(x: Int, y: Int,): List<Location> {
    val topLeft = location(x-1, y-1)
    val downLeft = location(x-1, y+1)
    val topRight = location(x+1, y-1)
    val downRight = location(x+1,y+1)
    return adjacently(x,y) + listOfNotNull(topLeft, downLeft, topRight, downRight)
}
