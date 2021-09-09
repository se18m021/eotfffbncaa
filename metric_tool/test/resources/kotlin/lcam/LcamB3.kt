package io.company.app.view.basket.kotlin.lcam

internal class LcamB3(myFieldConstructorValue: String) {
    private var myField: String = myFieldConstructorValue

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
