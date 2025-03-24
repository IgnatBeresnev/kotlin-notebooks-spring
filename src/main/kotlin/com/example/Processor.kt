package com.example

import org.springframework.stereotype.Component

interface Processor<T> {
    fun process(t: T) : T
}

@Component
class NoopStringProcessor : Processor<String> {
    override fun process(t: String): String {
        return t
    }
}

@Component
class DuplicatingStringProcessor : Processor<String> {
    override fun process(t: String): String {
        return "$t+$t"
    }
}

@Component
class NoopIntProcessor : Processor<Int> {
    override fun process(t: Int): Int {
        return t
    }
}

@Component
class UsageExample(
    private val stringProcessors: List<Processor<String>>
) {
    fun countProcessors(): Int {
        // should be 2, the Int processor does not count
        return stringProcessors.size
    }

    fun process(s: String): String {
        return stringProcessors.fold(s) { s, processor ->
            processor.process(s)
        }
    }
}
