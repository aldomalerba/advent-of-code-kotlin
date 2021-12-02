package e2e

import Day1
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day1AcceptanceTest {

    @Test
    fun `happy path part 1`() {
        val measurements = listOf(
            "199",
            "200",
            "208",
            "210",
            "200",
            "207",
            "240",
            "269",
            "260",
            "263"
        )
        val result = Day1().execute(measurements, 1)
        Assertions.assertEquals(7, result)
    }

    @Test
    fun `happy path part 2`() {
        val measurements = listOf(
            "199",
            "200",
            "208",
            "210",
            "200",
            "207",
            "240",
            "269",
            "260",
            "263"
        )

        val result = Day1().execute(measurements,3)
        Assertions.assertEquals(5, result)
    }
}