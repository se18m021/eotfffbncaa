package io.company.app.view.basket.kotlin.lcam

internal data class LcamJ(
    val myField1: String,
    val myField2: String
) {
    lateinit var myField3: String
    val getter get() = myField1 + myField2
}
