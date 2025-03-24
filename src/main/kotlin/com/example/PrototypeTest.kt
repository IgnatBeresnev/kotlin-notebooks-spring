package com.example

import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PrototypeTest {
    val number: Int = Random.Default.nextInt(10000)

    fun test() = "Number is: $number"
}
