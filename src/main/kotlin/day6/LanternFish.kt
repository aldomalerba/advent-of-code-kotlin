package day6

class LanternFish {

    fun execute(initialState: String, days: Int): Long {
        var timers = initialState.split(",").map { it.toInt() }.sorted()
        return timers.groupingBy { it }.eachCount().map { live( days, it.key) * it.value }.sum()
    }

    private fun live(end: Int, timer: Int) : Long {

        if (timer >= end) return 1
        return live(end, timer + 7) + live(end, timer + 9)

    }

}








