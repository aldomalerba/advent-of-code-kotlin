import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DiagnosticReportTest {

    @Test
    fun `calculate gamma`() {

        val result = DiagnosticReport().gamma(
            listOf(
                "00100",
                "11110",
                "10110",
                "10111",
                "10101",
                "01111",
                "00111",
                "11100",
                "10000",
                "11001",
                "00010",
                "01010")
        )

        assertEquals(22, result)

    }

    @Test
    fun `calculate epsilon`() {

        val result = DiagnosticReport().epsilon(
            listOf(
                "00100",
                "11110",
                "10110",
                "10111",
                "10101",
                "01111",
                "00111",
                "11100",
                "10000",
                "11001",
                "00010",
                "01010")
        )

        assertEquals(9, result)

    }
}