import java.io.File

fun main(args: Array<String>) {

    val input = File("src","Input.txt").readLines().map { it.trim() }
    val output = Day2(AimSubmarine()).execute(input)
    println(output)

}