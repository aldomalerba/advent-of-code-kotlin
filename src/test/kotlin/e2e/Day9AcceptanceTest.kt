package e2e

import day9.SmokeBasin
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day9AcceptanceTest {

    @Test
    fun `happy path part 1`() {

        val result = SmokeBasin().riskLevel(
            listOf(
                "2199943210",
                "3987894921",
                "9856789892",
                "8767896789",
                "9899965678"
            )
        )

        assertEquals(15,result)
    }

    @Test
    fun `happy path part 2`() {

        val result = SmokeBasin().basins(
            listOf(
                "2199943210",
                "3987894921",
                "9856789892",
                "8767896789",
                "9899965678"
            )
        )

        assertEquals(1134,result)
    }

}
