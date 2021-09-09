package dart_metrics.dart

import dart_metrics.AbstractMetricCalculatorTest
import dart_metrics.evaluator.impl.MetricCalculatorDIT
import dart_metrics.parser.FileParser
import dart_metrics.parser.impl.DartFileParser
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class DartMetricCalculatorDITTest : AbstractMetricCalculatorTest(
    metricName = "DIT",
    resourcesFolder = "dart/dit/lib",
    parser = DartFileParser(),
    projectCalculator = { parser: FileParser -> MetricCalculatorDIT(parser) }
) {
    @Test
    fun `(DitA) DIT for empty class`() {
        assertMetric("DitA", 0)
    }

    @Test
    fun `(DitB) DIT for multiple class in same file inheriting each other`() {
        assertMetric("DitB1", 0)
        assertMetric("DitB2", 1)
        assertMetric("DitB3", 2)
    }

    @Test
    fun `(DitD) DIT for class inheriting by import`() {
        assertMetric("DitD", 2)
    }

    @Test
    fun `(DitE) DIT for class inheriting from class not existing in project`() {
        assertMetric("DitE", 1)
    }

    @Test
    fun `(DitF) DIT for class inheriting from class not existing in project by fully qualified name`() {
        assertMetric("DitF", 1)
    }

    @Test
    fun `(DitG) DIT for class extending interface`() {
        assertMetric("DitG", 1)
    }

    @Test
    fun `(DitH) DIT for class extending interface and inheriting from class takes max value`() {
        assertMetric("DitH1", 2)
        assertMetric("DitH2", 3)
        assertMetric("DitH3", 1)
    }
}