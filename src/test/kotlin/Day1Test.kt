import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
class Day1Test {

    @Test
    fun `execute returns zero when measurements contains one measurement`() {
        val measurements = listOf(199)
        val result = Day1().execute(measurements, 1)
        assertEquals(0, result)
    }

    @Test
    fun `measurements contains only increased values`() {
        val measurements = listOf(199,200,208)
        val result = Day1().execute(measurements, 1)
        assertEquals(2, result)
    }

    @Test
    fun `measurements contains only decreased values`() {
        val measurements = listOf(199,198,197)
        val result = Day1().execute(measurements, 1)
        assertEquals(0, result)
    }

    @Test
    fun `sum how many measurements are larger than the previous measurement`() {
        val measurements = listOf(199,200,230,140,200)
        val result = Day1().execute(measurements, 1)
        assertEquals(3, result)
    }

    @Test
    fun `happy path`() {
        val measurements = listOf(
            199,
            200,
            208,
            210,
            200,
            207,
            240,
            269,
            260,
            263
        )
        val result = Day1().execute(measurements, 1)
        assertEquals(7, result)
    }

    @Test
    fun `execute sum of each three-measurement window`() {
        val measurements = listOf(
            199,
            200,
            208,
            210,
            200,
            207,
            240,
            269,
            260,
            263
        )

        val result = Day1().execute(measurements,3)
        assertEquals(5, result)
    }
}