package day6

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LanternFishTest {
    @Test
    fun `return list after one day`() {

        val result = LanternFish().execute("3,4,3,1,2", 1)
        assertEquals(listOf(2,3,2,0,1), result)

    }

    @Test
    fun `return list after two days`() {

        val result = LanternFish().execute("3,4,3,1,2", 2)
        assertEquals(listOf(1,2,1,6,0,8), result)

    }
}