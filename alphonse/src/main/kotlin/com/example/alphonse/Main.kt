package com.example.alphonse

import com.newrelic.api.agent.Trace
import java.net.URI
import java.nio.charset.Charset

fun main() {
    println("Alphonse is starting")
    while(true) {
        bowTwice()
        Thread.sleep(15)
    }
}

@Trace(dispatcher = true)
fun bowTwice() {
    Thread.sleep(5)
    bowWithoutErrors()
    Thread.sleep(10)
    bowWithoutErrors()
}

@Trace
fun bowWithoutErrors() {
    try {
        URI.create("http://gaston:8080/bow").toURL().openConnection().getInputStream().reader(Charset.defaultCharset()).readText()
    } catch (t: Throwable) {
    }
}