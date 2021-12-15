package e2e

import day13.TrasparentOrigami
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day13AcceptanceTest {
    @Test
    fun `happy path part 1`() {
        val result = TrasparentOrigami().execute(
            listOf(
                "6,10",
                "0,14",
                "9,10",
                "0,3",
                "10,4",
                "4,11",
                "6,0",
                "6,12",
                "4,1",
                "0,13",
                "10,12",
                "3,4",
                "3,0",
                "8,4",
                "1,10",
                "2,14",
                "8,10",
                "9,0",
                "",
                "fold along y=7",
                "fold along x=5"
            )
        )

        assertEquals(17, result)
    }
}

