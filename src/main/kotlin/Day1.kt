class Day1 {
    fun execute(measurements: List<Int>, slidingWindows: Int = 1): Int {

        List(measurements.dropLast(slidingWindows-1).size) { index -> measurements.drop(index).take(slidingWindows).sum()
        }.also {
            return it.drop(1).filterIndexed { index, item -> item > it[index] }.size
        }

    }
}