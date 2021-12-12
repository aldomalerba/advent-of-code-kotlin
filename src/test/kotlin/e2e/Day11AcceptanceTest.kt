package e2e

import da11.DumboOctopus
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day11AcceptanceTest {

    @Test
    fun `happy path part 1`() {
        val result = DumboOctopus().execute(
            listOf(
                "5483143223",
                "2745854711",
                "5264556173",
                "6141336146",
                "6357385478",
                "4167524645",
                "2176841721",
                "6882881134",
                "4846848554",
                "5283751526"
            ),
            100
        )

        assertEquals(1656,result)
    }

    @Test
    fun `happy path part 2`() {
        val result = DumboOctopus().execute(
            listOf(
                "5483143223",
                "2745854711",
                "5264556173",
                "6141336146",
                "6357385478",
                "4167524645",
                "2176841721",
                "6882881134",
                "4846848554",
                "5283751526"
            )
        )

        assertEquals(195,result)
    }
}