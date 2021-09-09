package dart_metrics

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNotNull
import dart_metrics.evaluator.FileMetricEvaluator
import dart_metrics.FileWalkHelper.getAllSubdirectoryFiles
import dart_metrics.evaluator.ClassMetricResult
import dart_metrics.evaluator.MetricCalculator
import dart_metrics.evaluator.ProjectMetricCalculator
import dart_metrics.parser.FileParser
import java.io.File
import java.util.*

internal abstract class AbstractMetricCalculatorTest(
    private val metricName: String,
    private val resourcesFolder: String,
    private val parser: FileParser,
    private val metricCalculator: (FileParser) -> MetricCalculator<*>? = { null },
    private val projectCalculator: (FileParser) -> ProjectMetricCalculator<*>? = { null }
) {
    protected val result = calculateMetric()

    private fun calculateMetric(): List<ClassMetricResult> {
        val resources = Objects.requireNonNull(javaClass.classLoader.getResources(resourcesFolder))
        val files = resources.toList().flatMap { File(it.file).getAllSubdirectoryFiles() }
        val fileEvaluator = FileMetricEvaluator(files, parser, listOfNotNull(metricCalculator(parser)), listOfNotNull(projectCalculator(parser)))
        return fileEvaluator.calculateMetrics()
    }

    protected fun assertMetric(className: String, resultValue: Any) {
        val metricResults = result.filter { it.className == className }
        assertThat(metricResults.size, "No or multiple results for class $className").isEqualTo(1)
        val metricResult = metricResults.first()
        assertMetric(metricResult, className, resultValue)
    }

    protected fun assertMetric(className: String, fullFileNameEndsWith: String, resultValue: Any) {
        val metricResults = result.filter { it.className == className && it.fullFileName.endsWith(fullFileNameEndsWith) }
        assertThat(metricResults.size, "No or multiple results for class $className in file ending with $fullFileNameEndsWith").isEqualTo(1)
        val metricResult = metricResults.first()
        assertMetric(metricResult, className, resultValue)
    }

    private fun assertMetric(metricResult: ClassMetricResult, className: String, resultValue: Any) {
        assertThat(metricResult, "$metricName for class $className").isNotNull()
        assertThat(metricResult.metrics.size, "$metricName for class $className has multiple result entries").isEqualTo(1)
        val metricsResult = metricResult.metrics.first()
        assertThat(metricsResult.metric).isEqualTo(metricName)
        assertThat(metricsResult.result).isEqualTo(resultValue)
    }
}

