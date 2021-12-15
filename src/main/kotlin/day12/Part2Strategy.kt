package day12

class Part2Strategy : Strategy {

    override fun newPath(path: List<String>, value: String): List<String>? {
        val findLowerCaseDuplicated = path.filter { it.all { it.isLowerCase() } }.groupingBy { it }.eachCount().any { it.value > 1 }
        return if (value.all { it.isLowerCase() } && path.contains(value) && findLowerCaseDuplicated) null
        else listOf(*path.toTypedArray(), value)
    }

}
