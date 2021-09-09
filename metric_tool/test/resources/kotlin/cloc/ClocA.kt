package io.company.app.view.basket.kotlin.cloc

import io.company.app.view.basket.kotlin.cloc.ClocA

/**
 * MyClass
 * this is some comment
 */
internal class ClocA {
    // some comment
    private val myString: String = ""

    /// this returns the local string + the value
    @Override
    private fun myFun(value: String): String {
        val local = myString
        /*
            some multiline
            comment
         */
        return local + value
    }
}
