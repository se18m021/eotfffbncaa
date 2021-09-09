package io.company.app.view.basket.kotlin.wmc

internal class WmcJ {
    fun method1() {
        when (0) {
            0 -> Unit
            1 -> Unit
            2 -> when (2) {
                0 -> Unit
                else -> Unit
            }
            else -> Unit
        }
    }

    fun method2() {
        when (0) {
            0 -> Unit
            else -> Unit
        }
    }
}
