package io.company.app.view.basket.kotlin.lcam

internal class LcamC() {
    private lateinit var myField: String

    constructor(myFieldConstructorValue: String) : this() {
        myField = myFieldConstructorValue
    }

    fun setField(value: String) {
        myField = value
    }

    fun getField(): String {
        return myField
    }
}
