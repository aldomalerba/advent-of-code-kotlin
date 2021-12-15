import day13.TrasparentOrigami
import java.io.File

fun main() {

    fun part1(input: List<String>) : Int{
        return TrasparentOrigami().execute(input)
    }

    val input = File("src","Day13.txt").readLines().map { it.trim() }
    println("output part 1: " + part1(input))

}