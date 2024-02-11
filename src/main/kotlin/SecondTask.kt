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

fun firstTask() {

}

fun secondTask() {

}