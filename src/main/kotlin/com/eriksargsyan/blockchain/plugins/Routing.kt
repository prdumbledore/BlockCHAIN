package com.eriksargsyan.blockchain.plugins

import com.eriksargsyan.blockchain.data.Block
import com.eriksargsyan.blockchain.data.addBlock
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

val blockchain = mutableListOf<Block>()

fun Application.configureRouting() {
    routing {
        get("/blocks") {
            call.respond(blockchain)
        }

        post("/blocks") {
            blockchain.addBlock()
            call.respond(HttpStatusCode.Created, blockchain.last())
        }
    }


}
