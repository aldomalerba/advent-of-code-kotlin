package day12

interface Strategy {
    fun newPath(path: List<String>, value: String): List<String>?
}