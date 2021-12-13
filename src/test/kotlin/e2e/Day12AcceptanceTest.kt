package e2e

import day12.PassagePathing
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day12AcceptanceTest {

    @Test
    fun `happy path part 1`() {
        val result = PassagePathing().execute(
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
}