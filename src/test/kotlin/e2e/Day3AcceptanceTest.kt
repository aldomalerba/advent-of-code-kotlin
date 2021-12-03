package e2e

import Day3
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@Disabled
class Day3AcceptanceTest {

    @Test
    fun `happy path`() {

        val result = Day3().execute(
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