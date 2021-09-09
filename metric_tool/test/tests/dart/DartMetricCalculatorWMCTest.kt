package dart_metrics.dart

import dart_metrics.AbstractMetricCalculatorTest
import dart_metrics.evaluator.impl.MetricCalculatorWMC
import dart_metrics.parser.FileParser
import dart_metrics.parser.impl.DartFileParser
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class DartMetricCalculatorWMCTest : AbstractMetricCalculatorTest(
    metricName = "WMC",
    resourcesFolder = "dart/wmc/",
    parser = DartFileParser(),
    metricCalculator = { parser: FileParser -> MetricCalculatorWMC(parser) }
) {
    @Test
    fun `(WmcA) WMC for empty class`() {
        assertMetric("WmcA", 1)
    }

    @Test
    fun `(WmcB) WMC for class with with two methods`() {
        assertMetric("WmcB", 3)
    }

    @Test
    fun `(WmcC) WMC for class with three secondary secondary constructor and primary constructor`() {
        assertMetric("WmcC", 4)
    }

    @Test
    fun `(WmcD) WMC for object with with two methods`() {
        assertMetric("WmcD", 2)
    }

    @Test
    fun `(WmcE) WMC for file with two classes`() {
        assertMetric("WmcE1", 3)
        assertMetric("WmcE2", 2)
    }

    @Test
    fun `(WmcF) WMC for file with a class and two global methods`() {
        assertMetric("WmcF", 3)
        assertMetric("wmc_f.dart", 2)
    }


    @Test
    fun `(WmcG) WMC for file with complexity of 'if'`() {
        assertMetric("WmcG", 6)
    }

    @Test
    fun `(WmcH) WMC for file with complexity of 'for'`() {
        assertMetric("WmcH", 6)
    }

    @Test
    fun `(WmcI) WMC for file with complexity of 'while'`() {
        assertMetric("WmcI", 6)
    }

    @Test
    fun `(WmcJ) WMC for file with complexity of 'switch'`() {
        assertMetric("WmcJ", 8)
    }

    @Test
    fun `(WmcK) WMC for file with complexity of 'catch'`() {
        assertMetric("WmcK", 6)
    }

    @Test
    fun `(WmcL) WMC for file with complexity of 'throw'`() {
        assertMetric("WmcL", 6)
    }

    @Test
    fun `(WmcM) WMC for file with complexity of 'and operator' and 'or operator'`() {
        assertMetric("WmcM", 8)
    }

    @Test
    fun `(WmcN) WMC for file with complexity of 'inline if statement'`() {
        assertMetric("WmcN", 6)
    }
}
