package io.company.app.view.basket.kotlin.lcam

internal class LcamB2(myFieldConstructorValue: String) {
    private var myField: String

    init {
        myField = myFieldConstructorValue
    }

    fun setField(value: String) {
        myField = value
    }

    fun getField(): String {
        return myField
    }

    fun getSomethingElse(): String {
        return "somethingElse"
    }
}
