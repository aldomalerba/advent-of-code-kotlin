package day12

class PassagePathing(private val strategy: Strategy) {
    fun execute(values: List<String>): List<List<String>> {
        val connections = values.map { it.split("-") }
        val nodes = connections.flatten().distinct()

        val paths = nodes.associateWith { node ->
            connections.filter { it.contains(node) }.flatten().distinct().filter { it != node && it != "start" }
        }


        return allPaths(listOf("start"), paths)
    }

    private fun allPaths(path: List<String>, nodeConnections: Map<String, List<String>>): List<List<String>> {

        val destinations = nodeConnections[path.last()]!!
        var newPaths = destinations.mapNotNull { strategy.newPath(path, it) }

        if (newPaths.all { isCompleted(it) }) return newPaths


        val completedPaths = newPaths.filter { isCompleted(it) }.toMutableList()
        val uncompletedPaths = newPaths.filter { isNotCompleted(it) }

        uncompletedPaths.forEach {
            completedPaths.addAll(allPaths(it, nodeConnections))
        }

        return completedPaths

    }

    private fun isCompleted(path: List<String>) = path.last() == "end"
    private fun isNotCompleted(path: List<String>) = !isCompleted(path)

}