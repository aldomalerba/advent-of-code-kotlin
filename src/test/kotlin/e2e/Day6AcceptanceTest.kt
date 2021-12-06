package e2e

import day6.LanternFish
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day6AcceptanceTest {

    @Test
    fun `happy path part 1`() {
        val result = LanternFish().execute("3,4,3,1,2", 80)
        assertEquals(5934, result)
    }


    @Test
    fun `happy path part 2`() {

        val result = LanternFish().execute("3,4,3,1,2", 256)
        assertEquals(26984457539, result)
    }
}