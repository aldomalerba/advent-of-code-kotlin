package day14

class ExtendedPolymerization {

    fun execute(values: List<String>, steps: Int): Int {

        var template = values.first()
        val rules = values.filter { it.contains("->") }.map {
            it.split(" -> ")
        }.associate { it.first() to "${it.first().first()}${it.last()}${it.first().last()}" }

        var counts = template.groupingBy { it }.eachCount().toMutableMap()

        val pairs = template.windowed(2)

        val newCounts = updateCount(10, pairs, rules, counts)

        return newCounts.maxOf { it.value } - counts.minOf { it.value }
    }

    private fun updateCount(steps: Int, pairs: List<String>, rules: Map<String, String>, counts: MutableMap<Char, Int>) : Map<Char, Int>{

        if(steps==0) return  counts

        var newCounts = mapOf<Char, Int>()

        pairs.parallelStream().forEach {
            val char = rules[it]!![1]
            val count = counts[char] ?: 0
            counts[char] = count + 1
            val newPairs = rules[it]!!.windowed(2)
            newCounts = updateCount(steps - 1, newPairs, rules, counts).toMutableMap()
        }

        return  newCounts
    }


}
