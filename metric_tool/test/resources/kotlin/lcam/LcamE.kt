package io.company.app.view.basket.kotlin.lcam

internal class LcamE(private val myField: String) {

    fun getField(): String {
        return this.myField
    }

    fun getFieldAsLocalVariable(): String {
        val myField = "field as local variable"
        return myField
    }

    fun getFieldWithParameterVariable(myField: String): String {
        return myField + myField
    }
}
