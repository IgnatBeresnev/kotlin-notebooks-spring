package com.example

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service
import kotlin.random.Random

interface TestService {
    fun foo(): String
}

@Service
@Profile("dev")
class HardcodedTestService : TestService {
    override fun foo(): String {
        return "123"
    }
}

@Service
@Profile("prod")
class RandomTestService : TestService {
    override fun foo(): String {
        return Random.nextInt().toString()
    }
}
