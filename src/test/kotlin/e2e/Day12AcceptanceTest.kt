package e2e

import day12.Part1Strategy
import day12.Part2Strategy
import day12.PassagePathing
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day12AcceptanceTest {

    @Test
    fun `happy path part 1a`() {
        val result = PassagePathing(Part1Strategy()).execute(
            values = listOf(
                "start-A",
                "start-b",
                "A-c",
                "A-b",
                "b-d",
                "A-end",
                "b-end"
            )
        )
        assertEquals(10, result.size)
    }

    @Test
    fun `happy path part 2`() {
        val result = PassagePathing(Part2Strategy()).execute(
            values = listOf(
                "start-A",
                "start-b",
                "A-c",
                "A-b",
                "b-d",
                "A-end",
                "b-end"
            )
        )

        result.forEach { println(it) }
        assertEquals(36, result.size)
    }
}