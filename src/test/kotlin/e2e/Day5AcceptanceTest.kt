package e2e

import day5.Day5Parser
import day5.HydrothermalVents
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day5AcceptanceTest {

    @Test
    fun `happy path part 1`() {
        val result = HydrothermalVents(Day5Parser()).execute(
            listOf(
                "0,9 -> 5,9",
                "8,0 -> 0,8",
                "9,4 -> 3,4",
                "2,2 -> 2,1",
                "7,0 -> 7,4",
                "6,4 -> 2,0",
                "0,9 -> 2,9",
                "3,4 -> 1,4",
                "0,0 -> 8,8",
                "5,5 -> 8,2"
            )
        )

        assertEquals(5, result)
    }
}