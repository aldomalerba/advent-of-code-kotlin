import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
class Day1Test {

    @Test
    fun `execute returns zero when measurements contains one measurement`() {
        val measurements = listOf(199)
        val result = Day1().execute(measurements)
        assertEquals(0, result)
    }

    @Test
    fun `measurements contains only increased values`() {
        val measurements = listOf(199,200,208)
        val result = Day1().execute(measurements)
        assertEquals(2, result)
    }

    @Test
    fun `measurements contains only decreased values`() {
        val measurements = listOf(199,198,197)
        val result = Day1().execute(measurements)
        assertEquals(0, result)
    }
}