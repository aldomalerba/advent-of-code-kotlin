import java.io.File

fun main(args: Array<String>) {

    val input = File("src","Input.txt").readLines().map { it.trim() }
    val output = Day2(Submarine()).execute(input)
    println(output)

}