import day2.MoveSubmarine
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day2Test{

    @Test
    fun `for each command move the submarine and then multiply horizontal and depth positions`() {

        val submarine = mockk<MoveSubmarine>(relaxed = true)

        every { submarine.horizontal() } returns 15
        every { submarine.depth() } returns 10

        val result = Day2(submarine).execute(listOf("anyCommand 1", "anyCommand 2", "anyCommand 3"))

        verify(exactly = 3) { submarine.execute(any(), any()) }

        assertEquals(150, result)
    }
}