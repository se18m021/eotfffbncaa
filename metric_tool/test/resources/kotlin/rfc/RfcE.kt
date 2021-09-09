package io.company.app.view.basket.kotlin.rfc

import io.company.app.view.basket.kotlin.rfc.other.RfcOther

internal class RfcE1 {
    fun method() {
        val rfcOther = RfcOther()
        rfcOther.method1()
        rfcOther.method2(1)
    }
}

internal class RfcE2 {
    fun method() {
        val rfcOther = RfcOther()
        rfcOther.method1()
    }
}