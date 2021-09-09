package dart_metrics.dart

import dart_metrics.AbstractMetricCalculatorTest
import dart_metrics.evaluator.impl.MetricCalculatorNOC
import dart_metrics.parser.FileParser
import dart_metrics.parser.impl.DartFileParser
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class DartMetricCalculatorNOCTest : AbstractMetricCalculatorTest(
    metricName = "NOC",
    resourcesFolder = "dart/noc/lib",
    parser = DartFileParser(),
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
    fun `(NocF) NOC for class extending class in different package using relative path import`() {
        assertMetric("NocF1", 0)
        assertMetric("NocF2", 0)
        assertMetric("NocFParent", 2)
    }

    @Test
    fun `(NocG) NOC for class extending class which exists in same file and imported file`() {
        assertMetric("NocG", 0)
        assertMetric("NocGParent", "noc_g.dart", 1)
        assertMetric("NocGParent", "other\\noc_g_parent.dart", 0)
    }

    @Test
    fun `(NocH) NOC for class extending class in different package using package import`() {
        assertMetric("NocH", 0)
        assertMetric("NocHParent", 1)
    }
}
