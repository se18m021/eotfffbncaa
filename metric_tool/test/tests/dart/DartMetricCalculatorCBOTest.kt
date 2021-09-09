package dart_metrics.dart

import dart_metrics.AbstractMetricCalculatorTest
import dart_metrics.evaluator.impl.MetricCalculatorCBO
import dart_metrics.parser.FileParser
import dart_metrics.parser.impl.DartFileParser
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class DartMetricCalculatorCBOTest : AbstractMetricCalculatorTest(
    metricName = "CBO",
    resourcesFolder = "dart/cbo/lib",
    parser = DartFileParser(),
    projectCalculator = { parser: FileParser -> MetricCalculatorCBO(parser) }
) {
    @Test
    fun `(CboA) CBO for empty class`() {
        assertMetric("cbo_a.dart", 0)
    }

    @Test
    fun `(CboB) CBO for class with parent using absolute path import`() {
        assertMetric("cbo_b.dart", 1)
    }

    @Test
    fun `(CboBParent) CBO for class that is parent by absolute path import`() {
        assertMetric("cbo_b_parent.dart", 1)
    }

    @Test
    fun `(CboC) CBO for class with parent using relative path import`() {
        assertMetric("cbo_c.dart", 1)
    }

    @Test
    fun `(CboCParent) CBO for class that is parent using relative path import`() {
        assertMetric("cbo_c_parent.dart", 1)
    }

    @Test
    fun `(CboD) CBO for class with field values using alias`() {
        assertMetric("cbo_d.dart", 1)
    }

    @Test
    fun `(CboE) CBO for class with constructor calls in method using import and alias name import`() {
        assertMetric("cbo_e.dart", 1)
    }

    @Test
    fun `(CboF) CBO for class with method call of static class using import`() {
        assertMetric("cbo_f.dart", 1)
    }

    @Test
    fun `(CboG) CBO for class with method call of static class using import and fully qualified name`() {
        assertMetric("cbo_g.dart", 2)
    }

    @Test
    fun `(CboGStatic) CBO for static class which is called by other class by alias name`() {
        assertMetric("cbo_g_static.dart", 1)
    }

    @Test
    fun `(CboI) CBO for class with alias import`() {
        assertMetric("cbo_i.dart", 1)
    }

    @Test
    fun `(CboOther) CBO for 2 classes in same package with 2 usages each`() {
        assertMetric("cbo_static_class.dart", 3)
        assertMetric("cbo_sub_class.dart", 3)
    }
}

