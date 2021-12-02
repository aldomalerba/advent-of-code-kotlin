import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SubmarineTest {

    @Test
    fun `initial horizontal and depth positions are zero`() {

        val submarine = Submarine()

        assertEquals(0, submarine.horizontal())
        assertEquals(0, submarine.depth())
    }

    @Test
    fun `increases the horizontal position by X units`() {

        val submarine = Submarine()
        submarine.execute("forward 5")
        assertEquals(5, submarine.horizontal())
    }

    @Test
    fun `increases depth by X units`() {

        val submarine = Submarine()
        submarine.execute("down 5")
        assertEquals(5, submarine.depth())
    }

    @Test
    fun `decreases depth by X units`() {

        val submarine = Submarine()
        submarine.execute("down 8")
        submarine.execute("up 5")
        assertEquals(3, submarine.depth())
    }
}