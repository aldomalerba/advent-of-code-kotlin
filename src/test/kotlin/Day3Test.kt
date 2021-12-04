import day3.DiagnosticReport
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day3Test {

    @Test
    fun `calculate power consumption`() {

        val report = mockk<DiagnosticReport>()
        every { report.powerConsumption(any()) } returns 198
        val numbers = listOf("anyItem")

        val result = Day3(report).execute(numbers)

        verify{ report.powerConsumption(numbers) }
        assertEquals(198, result)
    }
}