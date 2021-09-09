package dart_metrics.dart

import dart_metrics.AbstractMetricCalculatorTest
import dart_metrics.evaluator.impl.MetricCalculatorCLOC
import dart_metrics.parser.FileParser
import dart_metrics.parser.impl.DartFileParser
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class DartMetricCalculatorCLOCTest : AbstractMetricCalculatorTest(
    metricName = "CLOC",
    resourcesFolder = "dart/cloc",
    parser = DartFileParser(),
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
    fun `(ClocC) CLOC for global function in file`() {
        assertMetric("cloc_c.dart", 4)
    }
}

