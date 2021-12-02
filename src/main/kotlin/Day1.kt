class Day1 {
    fun execute(measurements: List<Int>, slicingSize: Int): Int {
        var measurements = groupSlicingWindows(measurements, slicingSize)
        return measurements.drop(1).filterIndexed { index, item -> item > measurements[index] }.size
    }

    private fun groupSlicingWindows(measurements: List<Int>, slicingSize: Int) =
        (0..(measurements.size - slicingSize)).map {
                index -> measurements.sumSlicingWindows(index, slicingSize)
        }

    private fun List<Int>.sumSlicingWindows(index: Int, slicingSize: Int) = drop(index).take(slicingSize).sum()
}