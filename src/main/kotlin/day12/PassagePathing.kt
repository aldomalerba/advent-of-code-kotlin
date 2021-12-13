package day12

class PassagePathing {
    fun execute(values: List<String>) : List<List<String>>{
        val connections = values.map { it.split("-") }
        val nodes = connections.flatten().distinct()

        val paths = nodes.associateWith { node ->
            val validConnections = connections.filter { it.contains(node) }.flatten().distinct().filter { it!= node }

            if(node!="start" && node!="end" && node.all { it.isLowerCase() }){
                validConnections.filter { it.none { it.isLowerCase() } || it=="end" }
            } else validConnections

        }.filterNot { it.value.isEmpty() }


        val value = "start"
        val destinations = paths[value]!!
        val path = listOf("start")



        return emptyList()
    }

}

//start, A, c,
//start, A, b
//start, A, end
//start, b