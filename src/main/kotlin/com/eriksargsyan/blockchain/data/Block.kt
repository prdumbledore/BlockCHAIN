package com.eriksargsyan.blockchain.data

import com.eriksargsyan.blockchain.util.generateData
import com.eriksargsyan.blockchain.util.sha256

data class Block(
    val index: Int,
    val prevHash: String,
    val hash: String,
    val data: String,
    val nonce: Int
) {
    companion object {
        fun createBlock(lastBlock: Block?): Block {
            val index = lastBlock?.let { it.index + 1 } ?: 0
            val previousHash = lastBlock?.hash ?: ""
            val data = generateData()
            var nonce = 0
            var hash: String

            do {
                nonce += 1

                hash = sha256(
                    buildString {
                        append(index)
                        append(previousHash)
                        append(data)
                        append(nonce)
                    }
                )
            } while (!hash.endsWith("0000"))

            return Block(index, previousHash, hash, data, nonce)
        }
    }
}