import java.io.File

fun main(args: Array<String>) {

    val day1Input = File("src","Day1.txt").readLines().map { it.trim().toInt() }
    val day1Output = Day1().execute(day1Input, 3)
    println(day1Output)

}