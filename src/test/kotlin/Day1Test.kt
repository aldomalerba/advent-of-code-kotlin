import day1.Day1
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
class Day1Test {

    @Test
    fun `execute returns zero when measurements contains one measurement`() {
        val measurements = listOf("199")
        val result = Day1().execute(measurements, 1)
        assertEquals(0, result)
    }

    @Test
    fun `measurements contains only increased values`() {
        val measurements = listOf("199","200","208")
        val result = Day1().execute(measurements, 1)
        assertEquals(2, result)
    }

    @Test
    fun `measurements contains only decreased values`() {
        val measurements = listOf("199","198","197")
        val result = Day1().execute(measurements, 1)
        assertEquals(0, result)
    }

    @Test
    fun `sum how many measurements are larger than the previous measurement`() {
        val measurements = listOf("199","200","230","140","200")
        val result = Day1().execute(measurements, 1)
        assertEquals(3, result)
    }
}