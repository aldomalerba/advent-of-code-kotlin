class Day1 {
    fun execute(measurements: List<Int>): Int {
        return measurements.filterIndexed { index, item -> if(index>0) item > measurements[index-1] else false }.size
    }
}