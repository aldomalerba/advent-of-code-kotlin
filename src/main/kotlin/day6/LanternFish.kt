package day6

class LanternFish {

    fun execute(initialState: String, days: Int): Long {
        var timers = initialState.split(",").map { it.toInt() }
        return timers.sumOf { live(0, days, it) }
    }

    private fun live(start: Int, end: Int, timer: Int) : Long {



        var total : Long = 1
        var age = timer

        (start until end).forEach { day ->

            if(age == 0) {
                total += live(day+3, end, 6)
                age = 6
            } else {
                age--
            }
        }

        return total

    }

}