package com.eriksargsyan.blockchain

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.eriksargsyan.blockchain.plugins.*
import kotlinx.coroutines.*

fun main(args: Array<String>) {
    embeddedServer(Netty, port = args[0].toInt(), host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureRouting()
}
