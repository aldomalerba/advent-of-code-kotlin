interface MoveSubmarine {

    fun execute(command: String, steps: Int)
    fun horizontal(): Int
    fun depth(): Int

}
