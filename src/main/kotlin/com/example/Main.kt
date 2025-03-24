package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}

@SpringBootApplication
class Application

@RestController
class TestController {

    @GetMapping("/test")
    fun foo() = "bar"
}
