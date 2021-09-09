package dart_metrics.kotlin

import dart_metrics.AbstractMetricCalculatorTest
import dart_metrics.evaluator.impl.MetricCalculatorCBO
import dart_metrics.parser.FileParser
import dart_metrics.parser.impl.KotlinFileParser
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class KotlinMetricCalculatorCBOTest : AbstractMetricCalculatorTest(
    metricName = "CBO",
    resourcesFolder = "kotlin/cbo/",
    parser = KotlinFileParser(),
    projectCalculator = { parser: FileParser -> MetricCalculatorCBO(parser) }
) {
    @Test
    fun `(CboA) CBO for empty class`() {
        assertMetric("CboA.kt", 0)
    }

    @Test
    fun `(CboB) CBO for class with parent using import`() {
        assertMetric("CboB.kt", 1)
    }

    @Test
    fun `(CboBParent) CBO for class that is parent by import`() {
        assertMetric("CboBParent.kt", 1)
    }

    @Test
    fun `(CboC) CBO for class with parent using fully qualified name`() {
        assertMetric("CboC.kt", 1)
    }

    @Test
    fun `(CboD) CBO for class with field values using fully qualified name`() {
        assertMetric("CboD.kt", 1)
    }

    @Test
    fun `(CboE) CBO for class with constructor calls in method using import and fully qualified name`() {
        assertMetric("CboE.kt", 1)
    }

    @Test
    fun `(CboF) CBO for class with method call of static class using import`() {
        assertMetric("CboF.kt", 1)
    }

    @Test
    fun `(CboH) CBO for class calling extension function using import and alias import`() {
        assertMetric("CboH.kt", 1)
    }

    @Test
    fun `(CboHExtensionFunctions) CBO for extension functions in file called from other class`() {
        assertMetric("CboHExtensionFunctions.kt", 1)
    }

    @Test
    fun `(CboI) CBO for class with alias import`() {
        assertMetric("CboI.kt", 1)
    }

    @Test
    fun `(CboJ) CBO for class with internal class import`() {
        assertMetric("CboJ.kt", 1)
    }

    @Test
    fun `(CboOther) CBO for 2 classes in same package with 2 usages each`() {
        assertMetric("CboStaticClass.kt", 4)
        assertMetric("CboSubClass.kt", 4)
    }
}

