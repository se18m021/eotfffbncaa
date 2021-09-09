package io.company.app.view.basket.kotlin.dit

internal open class DitB1

internal open class DitB2 : DitB1() {
    private val myValue = ""
}

internal object DitB3 : DitB2()
