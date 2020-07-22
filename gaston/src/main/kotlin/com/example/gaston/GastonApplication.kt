package com.example.gaston

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GastonApplication

fun main(args: Array<String>) {
	runApplication<GastonApplication>(*args)
}
