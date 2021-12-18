package day14

class ExtendedPolymerization {

    fun execute(values: List<String>, steps: Int): Long {

        var template = values.first()
        val rules = values.filter { it.contains("->") }.map {
            it.split(" -> ")
        }.associate { it.first() to Pair(it.last().first(), listOf("${it[0][0]}${it[1][0]}","${it[1][0]}${it[0][1]}")) }

        var pairCounts: MutableMap<String, Long> = rules.keys.associateWith { 0.toLong() }.toMutableMap()

        template.windowed(2).groupingBy { it }.eachCount().forEach {
            pairCounts[it.key] = it.value.toLong()
        }

        repeat(steps - 1) {

            val actualPairs = pairCounts.filter { it.value > 0 }
            pairCounts = mutableMapOf()

            actualPairs.map {
                listOf(
                    rules[it.key]!!.second.first() to it.value,
                    rules[it.key]!!.second.last() to it.value
                )
            }.flatten().groupBy { it.first }.map { it.key to it.value.sumOf { it.second } }
                .forEach {
                    pairCounts[it.first] = if (pairCounts.containsKey(it.first))
                        pairCounts[it.first]!! + it.second
                    else it.second
                }


        }


        val chars = pairCounts.keys.map { listOf(it.first(), it.last()) }.flatten().distinct()
        val countsChars : MutableMap<Char, Long> = chars.associateWith { 0.toLong() }.toMutableMap()

        pairCounts.forEach {
            val char = rules[it.key]!!.first
            val count = countsChars[char]!!
            countsChars[char] = count + it.value
        }

       chars.forEach { char ->
            val firstPosition = pairCounts.filter { it.key.first() == char }.toList().sumOf { it.second }
            val lastPosition = pairCounts.filter { it.key.last() == char }.toList().sumOf { it.second }
           val count = countsChars[char]!!
           countsChars[char] = count + maxOf(firstPosition, lastPosition)
        }

        return countsChars.maxOf { it.value } - countsChars.minOf { it.value }

    }
}