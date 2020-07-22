package com.example.gaston

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BowController {
    @GetMapping("/bow")
    fun bow(): String {
        Thread.sleep(20)
        return "{\"gaston\":\"has bowed back\"}"
    }

}