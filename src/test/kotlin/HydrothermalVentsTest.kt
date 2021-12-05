import day5.Day5Parser
import day5.HydrothermalVents
import day5.Point
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HydrothermalVentsTest {

    @Test
    fun `calculate the number of points where at least two lines overlap`() {

        val parser = mockk<Day5Parser>()

        every { parser.points(any()) } returns listOf(
            Point(1,4),
            Point(2,4),
            Point(3,4),
            Point(3,4),
            Point(4,4),
            Point(5,4),
            Point(6,4),
            Point(7,4),
            Point(8,4),
            Point(9,4),
            Point(7,0),
            Point(7,1),
            Point(7,2),
            Point(7,3),
            Point(7,4)
        )

        val result = HydrothermalVents(parser).execute(listOf("anyElement"))

        assertEquals(2, result)
    }
}