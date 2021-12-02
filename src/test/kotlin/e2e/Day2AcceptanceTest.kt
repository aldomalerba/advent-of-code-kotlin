package e2e

import Day2
import Submarine
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day2AcceptanceTest {
    @Test
    fun `happy path`() {

        val result = Day2(Submarine()).execute(listOf(
            "forward 5",
            "down 5",
            "forward 8",
            "up 3",
            "down 8",
            "forward 2"
        ))

        assertEquals(150, result)
    }
}