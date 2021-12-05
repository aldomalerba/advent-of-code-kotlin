import day5.Day5Parser
import day5.Part1Strategy
import day5.Point
import day5.Strategy
import io.mockk.every
import io.mockk.spyk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day5ParserTest {
    @Test
    fun `parse vents into points`() {

        val result = Day5Parser(Part1Strategy()).points(
            listOf(
                "6,4 -> 2,0",
                "1,1 -> 1,3",
                "9,7 -> 7,7"
            )
        )

        val expectedResult = listOf(
            Point(1,1),
            Point(1,2),
            Point(1,3),
            Point(7,7),
            Point(8,7),
            Point(9,7)
        )

        assertEquals(expectedResult, result)

    }

}