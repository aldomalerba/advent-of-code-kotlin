package e2e

import day7.AverageStrategy
import day7.FuelCalculator
import day7.MedianStrategy
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day7AcceptanceTest {

    @Test
    fun `happy path part 1`() {

        val result = FuelCalculator(MedianStrategy()).execute("16,1,2,0,4,2,7,1,2,14")
        assertEquals(37, result)

    }

    @Test
    fun `happy path part 2`() {

        val result = FuelCalculator(AverageStrategy()).execute("16,1,2,0,4,2,7,1,2,14")
        assertEquals(168, result)

    }

}