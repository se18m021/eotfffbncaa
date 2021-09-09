package io.company.app.view.basket.kotlin.cbo.i

import io.company.app.view.basket.kotlin.cbo.other.CboSubClass
import io.company.app.view.basket.kotlin.cbo.other.CboSubClass as CboClassNameOverride

internal class CboI {
    lateinit var cboSubClass: CboSubClass
    lateinit var cboClassNameOverride: CboClassNameOverride
}
