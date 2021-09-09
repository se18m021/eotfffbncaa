package io.company.app.view.basket.kotlin.dit

import io.company.app.view.basket.kotlin.dit.other.DitInterface1
import io.company.app.view.basket.kotlin.dit.other.DitInterface3
import io.company.app.view.basket.kotlin.dit.other.DitParentClass1
import io.company.app.view.basket.kotlin.dit.other.DitParentClass2

internal class DitH1 : DitParentClass2(), DitInterface1

internal class DitH2: DitParentClass2(), DitInterface3

internal class DitH3: DitParentClass1(), DitInterface1