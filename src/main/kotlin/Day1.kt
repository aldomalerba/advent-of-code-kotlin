class Day1 {

    fun execute(measurements: List<Int>, slicingSize: Int): Int {
        measurements.grouped(slicingSize).let {
            return it.increasingValues().size
        }
    }

    private fun List<Int>.grouped(slicingSize: Int) = windowed(slicingSize).map { it.sum() }
    private fun List<Int>.increasingValues() = drop(1).filterIndexed { index, item -> item > this[index] }
}