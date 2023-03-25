package com.eriksargsyan.blockchain.data

import com.eriksargsyan.blockchain.data.Block.Companion.createBlock

fun MutableList<Block>.addBlock() {
    if (this.isEmpty()) {
        this.add(createBlock(null))
    } else {
        this.add(createBlock(this.last()))
    }

}

