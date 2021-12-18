package e2e

import day14.ExtendedPolymerization
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day14AcceptanceTest {

    @Test
    fun `happy path part 1`() {
        val result = ExtendedPolymerization().execute(
            listOf(
                "NNCB",
                "",
                "CH -> B",
                "HH -> N",
                "CB -> H",
                "NH -> C",
                "HB -> C",
                "HC -> B",
                "HN -> C",
                "NN -> C",
                "BH -> H",
                "NC -> B",
                "NB -> B",
                "BN -> B",
                "BB -> N",
                "BC -> B",
                "CC -> N",
                "CN -> C"
            ), 40
        )

        assertEquals(1588, result)
    }
}