class Day1 {
    fun execute(measurements: List<Int>, slicingSize: Int = 1): Int {

        groupSlicingWindows(measurements, slicingSize).also {
            return it.drop(1).filterIndexed { index, item -> item > it[index] }.size
        }

    }

    private fun groupSlicingWindows(measurements: List<Int>, slicingSize: Int) =
        List(measurements.size - slicingSize + 1 ) {
                index -> measurements.sumSlicingWindows(index, slicingSize)
        }

    private fun List<Int>.sumSlicingWindows(index: Int, slicingSize: Int) = drop(index).take(slicingSize).sum()
}