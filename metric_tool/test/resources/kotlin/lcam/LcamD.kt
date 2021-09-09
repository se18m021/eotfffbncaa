package io.company.app.view.basket.kotlin.lcam

internal class LcamD {
    private lateinit var myField: String
    private lateinit var anotherField: String

    fun setField(value: String) {
        myField = value
    }

    fun setAnotherField(value: String) {
        anotherField = value
    }

    fun getCombinedFields(): String {
        return myField + anotherField
    }
}
