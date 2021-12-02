class AimSubmarine : MoveSubmarine {

    private var horizontal = 0
    private var depth = 0
    private var aim = 0

    override fun execute(direction: String, steps: Int) {

        when(direction){
            "down" -> aim += steps
            "up" -> aim -= steps
            else -> {
                horizontal += steps
                depth += steps * aim
            }
        }
    }

    override fun horizontal() = horizontal

    override fun depth() = depth

    fun aim() = aim

}
