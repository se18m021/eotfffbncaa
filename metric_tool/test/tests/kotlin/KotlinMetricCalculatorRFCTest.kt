package dart_metrics.kotlin

import dart_metrics.AbstractMetricCalculatorTest
import dart_metrics.evaluator.impl.MetricCalculatorRFC
import dart_metrics.parser.FileParser
import dart_metrics.parser.impl.KotlinFileParser
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class KotlinMetricCalculatorRFCTest : AbstractMetricCalculatorTest(
    metricName = "RFC",
    resourcesFolder = "kotlin/rfc/",
    parser = KotlinFileParser(),
    metricCalculator = { parser: FileParser -> MetricCalculatorRFC(parser) }
) {
    @Test
    fun `(RfcA) RFC for empty class`() {
        assertMetric("RfcA", 0)
    }

    @Test
    fun `(RfcB) RFC for class with with two methods calling its own method`() {
        assertMetric("RfcB", 2)
    }

    @Test
    fun `(RfcC) RFC for class with with a methods calling two different methods from other class`() {
        assertMetric("RfcC", 3)
    }

    @Test
    fun `(RfcD) RFC for object with with two methods calling same method from other class`() {
        assertMetric("RfcD", 4)
    }

    @Test
    fun `(RfcE) RFC for file with two classes`() {
        assertMetric("RfcE1", 3)
        assertMetric("RfcE2", 2)
    }

    @Test
    fun `(RfcF) RFC for file with a class and a global method`() {
        assertMetric("RfcF", 3)
        assertMetric("RfcF.kt", 2)
    }

    @Test
    fun `(RfcG) RFC for class with with a methods calling a method from other class from two different local objects`() {
        assertMetric("RfcG", 3)
    }

    @Test
    fun `(RfcH) RFC for class with with a method accessing a field from other class`() {
        assertMetric("RfcH", 1)
    }
}
