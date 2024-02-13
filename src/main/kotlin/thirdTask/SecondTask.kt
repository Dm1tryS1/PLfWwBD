package thirdTask

import java.util.*

fun main() {
    println("Input count of doors")
    val doorsCount = readln().toIntOrNull() ?: 1
    println("Input count of windows")
    val windowsCount = readln().toIntOrNull() ?: 1

    val house = House(List(doorsCount) { Door() }, List(windowsCount) { Window() })

    println("Your House")
    println(house)

    var exit = false

    while (!exit) {
        println("Choose action")
        println("1 - open/сlose door")
        println("2 - open/сlose window")
        val objectAction = readln().toIntOrNull() ?: 1
        println("Open or close?")
        println("0 - close")
        println("1 - open")
        val action = (readln().toIntOrNull() ?: 1) == 1
        println("Input index")
        val index = readln().toIntOrNull() ?: 1

        when (objectAction) {
            1 -> house.changeDoorState(action, index)
            2 -> house.changeWindowState(action, index)
            else -> {}
        }

        println("Your House")
        println(house)

        println("Exit? (Yes/No)")
        if (readln().lowercase(Locale.getDefault()) == "yes") {
            exit = true
        }
    }
}

data class House(val doors: List<Door>, val windows: List<Window>) {
    fun changeDoorState(state: Boolean, index: Int) {
        doors.getOrNull(index)?.state = state
    }

    fun changeWindowState(state: Boolean, index: Int) {
        windows.getOrNull(index)?.state = state
    }
}

data class Door(var state: Boolean = false)

data class Window(var state: Boolean = false)