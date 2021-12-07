package day7

class FuelCalculator(private val strategy: Strategy) {

    fun execute(input: String): Int {
        val positions = input.split(",").map { it.toInt() }
        return strategy.calculate(positions)
    }

}
