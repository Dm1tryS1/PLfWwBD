package org.example.second

import java.nio.file.Files
import java.nio.file.Paths
import kotlin.random.Random

fun main() {
    firstTask()
    secondTask()
}

fun firstTask() {
    println("First task")
    val ca = mutableMapOf<Int, Int>()
    val cb = mutableMapOf<Int, Int>()

    var isReadingFirstMatrix = true

    Files.lines(Paths.get(FileName.First.nameFile)).use { stream ->
        stream.forEach { value ->
            if (value.isNotBlank()) {
                val matrix = value.split(" ").mapNotNull { it.toIntOrNull() }
                if (matrix.size == COUNT_OF_NUMBER) {
                    if (isReadingFirstMatrix) {
                        ca[N * matrix[0] + matrix[1]] = matrix[2]
                    } else {
                        cb[N * matrix[0] + matrix[1]] = matrix[2]
                    }
                }
            } else {
                isReadingFirstMatrix = false
            }
        }
    }

    val sum = mutableMapOf<Int, Int>()
    repeat(N * N) {
        sum[it] = (ca[it] ?: 0) + (cb[it] ?: 0)
    }

    val mul = mutableMapOf<Int, Int>()

    for (i in 0..<N) {
        for (j in 0..<N) {
            var currentElement = 0
            for (k in 0..<N) {
                currentElement += (ca[i * N + k] ?: 0) * (cb[k * N + j] ?: 0)
            }
            mul[i * N + j] = currentElement
        }
    }

    println("CA:")
    println(ca)
    println("CB:")
    println(cb)
    println("Sum:")
    println(sum)
    println("Mul")
    println(mul)
}

fun secondTask() {
    println("Second task")
    val map = mutableMapOf<Int, String>()

    Files.lines(Paths.get(FileName.Second.nameFile)).use { stream ->
        stream.forEach { value ->
            map[Random.nextInt(1000)] = value
        }
    }
    println("Map:")
    println(map)
    println("Result:")
    println(map.toSortedMap().entries.distinctBy { it.value })
}

enum class FileName(val nameFile: String) {
    First("./src/main/resources/First"),
    Second("./src/main/resources/Second")
}

const val N = 3
const val COUNT_OF_NUMBER = 3