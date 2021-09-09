package io.company.app.view.basket.kotlin.lcam

internal class LcamB(private var myField: String) {
    fun setField(value: String) {
        myField = value
    }

    private fun getField(): String {
        return myField
    }

    private fun getSomethingElse(): String {
        return "somethingElse"
    }
}
