package day10

class SyntaxScoring() {

    private val simpleChunks = listOf("()","[]","{}","<>")
    private val closes = mapOf( ')' to '(', ']' to '[', '}' to '{', '>' to '<' )
    private val pointsIllegal = mapOf( ')' to 3, ']' to 57, '}' to 1197, '>' to 25137 )
    private val pointsIncomplete = mapOf( ')' to 1, ']' to 2, '}' to 3, '>' to 4 )

    fun score(values: List<String>) = illegalChars(values).mapNotNull { pointsIllegal[it] }.sum()
    fun middleScore(values: List<String>) : Long {

        incompleteStrings(values).map {
            it.fold(0){ score: Long, char -> score*5 + pointsIncomplete[char]!!}
        }.also {
            return it.sorted()[it.size/2]
        }

    }

    private fun illegalChars(values: List<String>) = values.mapNotNull { illegalChar(removeSimpleChunks(it)) }

    private fun incompleteStrings(values: List<String>) = values.mapNotNull {

        var line = removeSimpleChunks(it)

        if (illegalChar(line) == null) {
            line.map { closes.filter { close -> close.value == it }.keys.first() }.joinToString("").reversed()
        } else{
            null
        }

    }

    private fun illegalChar(line: String) =
        line.filterIndexed { index, char -> closes.containsKey(char) && line[index - 1] != closes[char] }.firstOrNull()

    private fun removeSimpleChunks(line: String): String {
        var reducedLine = line
        while (reducedLine.findAnyOf(simpleChunks) != null) {
            simpleChunks.forEach { chunk -> reducedLine = reducedLine.replace(chunk, "") }
        }
        return reducedLine
    }

}