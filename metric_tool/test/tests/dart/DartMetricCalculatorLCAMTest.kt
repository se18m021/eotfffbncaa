package dart_metrics.dart

import dart_metrics.AbstractMetricCalculatorTest
import dart_metrics.evaluator.impl.MetricCalculatorLCAM
import dart_metrics.parser.FileParser
import dart_metrics.parser.impl.DartFileParser
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class DartMetricCalculatorLCAMTest : AbstractMetricCalculatorTest(
    metricName = "LCAM",
    resourcesFolder = "dart/lcam/",
    parser = DartFileParser(),
    metricCalculator = { parser: FileParser -> MetricCalculatorLCAM(parser) }
) {
    @Test
    fun `(LcamA) LCAM for empty class`() {
        assertMetric("LcamA", 0.0)
    }

    @Test
    fun `(LcamB) LCAM for class with single field and reference in constructor`() {
        assertMetric("LcamB", 1.0 - (2.0 / 3.0))
    }

    @Test
    fun `(LcamB2) LCAM for class with single field and reference in constructor as named parameter`() {
        assertMetric("LcamB2", 1.0 - (2.0 / 3.0))
    }

    @Test
    fun `(LcamC) LCAM for class with single field and reference in secondary constructor`() {
        assertMetric("LcamC", 1.0 - (3.0 / 4.0))
    }

    @Test
    fun `(LcamD) LCAM for class with multiple fields referenced in multiple methods`() {
        assertMetric("LcamD", 1.0 - (4.0 / (2 * 4.0)))
    }

    @Test
    fun `(LcamE) LCAM for class with single field and method using same field name as local variable`() {
        assertMetric("LcamE", 1.0 - (2.0 / 3.0))
    }

    @Test
    fun `(LcamF) LCAM for class with single field and method referencing field with 'this' keyword`() {
        assertMetric("LcamF", 1.0 - (2.0 / 2.0))
    }

    @Test
    fun `(LcamG) LCAM for object with single field and method referencing field`() {
        assertMetric("LcamG", 1.0 - (1.0 / 1.0))
    }

    @Test
    fun `(LcamH) LCAM for file with multiple classes`() {
        assertMetric("LcamH1", 1.0 - (1.0 / 2.0))
        assertMetric("LcamH2", 1.0 - (1.0 / 2.0))
    }

    @Test
    fun `(LcamI) LCAM for class with method using expression body`() {
        assertMetric("LcamI", 1.0 - (1.0 / 2.0))
    }

    @Test
    fun `(LcamJ) LCAM for data class with getter referencing fields`() {
        assertMetric("LcamJ", 1.0 - (4.0 / (2.0 * 3.0)))
    }
}