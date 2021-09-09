package dart_metrics.kotlin

import dart_metrics.AbstractMetricCalculatorTest
import dart_metrics.evaluator.impl.MetricCalculatorNOC
import dart_metrics.parser.FileParser
import dart_metrics.parser.impl.KotlinFileParser
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class KotlinMetricCalculatorNOCTest : AbstractMetricCalculatorTest(
    metricName = "NOC",
    resourcesFolder = "kotlin/noc/",
    parser = KotlinFileParser(),
    projectCalculator = { parser: FileParser -> MetricCalculatorNOC(parser) }
) {
    @Test
    fun `(NocA) NOC for empty class`() {
        assertMetric("NocA", 0)
    }

    @Test
    fun `(NocB) NOC for open class with with three subclasses`() {
        assertMetric("NocB1", 3)
        assertMetric("NocB2", 0)
        assertMetric("NocB3", 0)
        assertMetric("NocB4", 0)
    }

    @Test
    fun `(NocC) NOC for classes with multiple inheritance`() {
        assertMetric("NocC1", 1)
        assertMetric("NocC2", 2)
        assertMetric("NocC3", 0)
        assertMetric("NocC4", 0)
    }

    @Test
    fun `(NocD) NOC for interfaces with multiple inheritance`() {
        assertMetric("NocD1", 0)
        assertMetric("NocD2", 0)
        assertMetric("NocD3", 0)
        assertMetric("NocD4", 0)
        assertMetric("NocD5", 0)
    }

    @Test
    fun `(NocE) NOC for class implementing interface interface and extending class`() {
        assertMetric("NocE1", 0)
        assertMetric("NocE2", 0)
        assertMetric("NocE3", 1)
        assertMetric("NocE4", 0)
    }

    @Test
    fun `(NocF) NOC for class extending class in different package`() {
        assertMetric("NocF1", 0)
        assertMetric("NocF2", 0)
        assertMetric("NocF3", 0)
        assertMetric("NocF", 3)
    }
}
