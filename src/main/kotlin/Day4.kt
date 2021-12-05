package day4
import java.io.File


fun main() {

    val input = File("src","Day4.txt").readLines().map { it.trim() }
    val winners = BingoSubsystem().play(input)
    println("output part 1 " + winners.first())
    println("output part 2 " + winners.last())
}