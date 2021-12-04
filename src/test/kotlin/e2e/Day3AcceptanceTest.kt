package e2e

import day3.DiagnosticReport
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day3AcceptanceTest {

    @Test
    fun `happy path part 1`() {

        val result = DiagnosticReport().powerConsumption(
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

        assertEquals(198, result)
    }

    @Test
    fun `happy path part 2`() {

        val result = DiagnosticReport().supportRating(
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

        assertEquals(198, result)
    }
}