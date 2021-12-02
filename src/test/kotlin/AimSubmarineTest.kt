import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AimSubmarineTest{


    @Test
    fun `initial horizontal and depth positions are zero`() {

        val submarine = AimSubmarine()
        assertEquals(0, submarine.horizontal())
        assertEquals(0, submarine.depth())
        assertEquals(0, submarine.aim())
    }

    @Test
    fun `down X increases your aim by X units`() {

        val submarine = AimSubmarine()
        submarine.execute("down", 5)
        assertEquals(5, submarine.aim())

    }

    @Test
    fun `up X decreases your aim by X units`() {

        val submarine = AimSubmarine()
        submarine.execute("down", 5)
        submarine.execute("up", 2)
        assertEquals(3, submarine.aim())

    }

    @Test
    fun `forward with aim at zero`() {

        val submarine = AimSubmarine()
        submarine.execute("forward", 5)
        assertEquals(5, submarine.horizontal())

    }

    @Test
    fun `forward with aim grater than zero`() {

        val submarine = AimSubmarine()
        submarine.execute("forward", 5)
        submarine.execute("down", 5)
        submarine.execute("forward", 8)
        assertEquals(40, submarine.depth())

    }
}