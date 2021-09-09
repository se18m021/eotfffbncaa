package io.company.app.view.basket.kotlin.lcam

internal class LcamF(private val myField: String) {

    fun getField(): String {
        return this.myField
    }

    fun getFieldWithLocalVariable(): String {
        val myField = "local"
        return myField + this.myField
    }

    fun getSomethingElse(): String {
        return "somethingElse"
    }
}
