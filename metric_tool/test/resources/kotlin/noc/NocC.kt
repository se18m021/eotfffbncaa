package io.company.app.view.basket.kotlin.noc

internal open class NocC1

internal open class NocC2 : NocC1()

internal class NocC3 : NocC2()

internal object NocC4 : NocC2()
