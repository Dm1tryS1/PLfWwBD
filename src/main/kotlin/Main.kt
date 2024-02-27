package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    firstTask()
    secondTask()
    thirdTask()
    fourthTask()
}

fun firstTask() {
    val result = INPUT_STRING.split(" ").stream().limit(2).reduce { t, u -> "$t $u" }.get()
    println(result)
}

fun secondTask() {
    val result = INPUT_STRING.split(" ").stream().skip(1).limit(2).reduce { t, u -> "$t $u" }.get()
    println(result)
}

fun thirdTask() {
    val result = listOf("a1", "a2", "a3", "a1").stream().map { it.removeRange(0, 1) }.toList()
    println(result)
}

fun fourthTask() {
    val result = INPUT_STRING.split(" ").stream().map { "${it}_task14"}.toList()
    println(result)
}

const val INPUT_STRING = "Hello! This is new task"