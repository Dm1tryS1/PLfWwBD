package org.example

fun main() {
    val array = mutableListOf<String>()
    println("Input N:")
    val n = readln()
    n.toIntOrNull()?.let { size ->
        repeat(size) {
            array.add(readln())
        }
        if (size > 0) {
            println("Result of first task:")
            firstTask(array)
            println("Result of second task:")
            secondTask(array)
        }
    }
}

fun firstTask(list: List<String>) {
    val avg = list.sumOf {
        it.length
    } / list.size

    println("More than average:")
    list.filter { it.length > avg }.forEach {
        println("$it length: ${it.length}")
    }

    println("Less than average:")
    list.filter { it.length < avg }.forEach {
        println("$it length: ${it.length}")
    }
}

fun secondTask(list: List<String>) {
    print(list.map {
        Pair(it, it.toSet().size)
    }.minBy {
        it.second
    }.first)
}