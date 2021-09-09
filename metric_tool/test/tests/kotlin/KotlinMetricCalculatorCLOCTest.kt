package dart_metrics.kotlin

import dart_metrics.AbstractMetricCalculatorTest
import dart_metrics.evaluator.impl.MetricCalculatorCLOC
import dart_metrics.parser.FileParser
import dart_metrics.parser.impl.KotlinFileParser
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class KotlinMetricCalculatorCLOCTest : AbstractMetricCalculatorTest(
    metricName = "CLOC",
    resourcesFolder = "kotlin/cloc",
    parser = KotlinFileParser(),
    metricCalculator = { parser: FileParser -> MetricCalculatorCLOC(parser) }
) {
    @Test
    fun `(ClocA) CLOC for class`() {
        assertMetric("ClocA", 8)
    }

    @Test
    fun `(ClocB) CLOC for multiple classes is same file`() {
        assertMetric("ClocB1", 3)
        assertMetric("ClocB2", 2)
        assertMetric("ClocB3", 1)
    }

    @Test
    fun `(ClocC) CLOC for extension function in file`() {
        assertMetric("ClocC.kt", 4)
    }

    @Test
    fun `(ClocD) CLOC for class and extension function in file`() {
        assertMetric("ClocD", 2)
        assertMetric("ClocD.kt", 3)
    }

    @Test
    fun `(ClocE) CLOC for nested class`() {
        assertMetric("ClocE", 5)
    }
}

