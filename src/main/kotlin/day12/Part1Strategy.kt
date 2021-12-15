package day12

class Part1Strategy : Strategy {

    override fun newPath(path: List<String>, value: String): List<String>? {
        return if (value.all { it.isLowerCase() } && path.contains(value)) null
        else listOf(*path.toTypedArray(), value)
    }

}
