package org.example.first_task

import org.example.first_task.Mobile.Companion.DEFAULT_MEMORY_SIZE

fun main() {
    println("Input model")
    val model = readln()
    println("RAM size")
    val ramSize = readln().toIntOrNull() ?: DEFAULT_MEMORY_SIZE
    println("Memory size")
    val memory = readln().toIntOrNull() ?: DEFAULT_MEMORY_SIZE
    println("Input camera parameters")
    val camera = readln().toIntOrNull() ?: DEFAULT_MEMORY_SIZE

    val mobile = Mobile(Mobile.Information(model, ramSize, memory, camera))
    mobile.getInformation()
}

class Mobile(private val information: Information) {

    fun getInformation() {
        println("$information")
    }


    class Information(
        private val model: String,
        private val ramSize: Int,
        private val memory: Int,
        private val camera: Int
    ) {
        override fun toString(): String =
            "model: $model; RAM size: ${ramSize}Gb; memory: ${memory}Gb; camera: ${camera}Mp"
    }

    companion object {
        const val DEFAULT_MEMORY_SIZE = 16
    }
}