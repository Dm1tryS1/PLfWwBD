package org.example.second_task

fun main() {
    val theater = Theater("Big Theater", false)

    theater.changeLightsState(true)
    theater.changeState(true)
}

class Theater(override val address: String, override var state: Boolean) : PublicBuilding(address, state) {
    override fun changeState(newState: Boolean) {
        super.changeState(newState)
        println("New state: $state")
    }

    override fun changeLightsState(state: Boolean) =
        println("Lights ${if (state) java.lang.String("on") else java.lang.String("off")}")

}

abstract class PublicBuilding(override val address: String, protected open var state: Boolean) : Building {
    open fun changeState(newState: Boolean) {
        state = newState
    }
}

interface Building {

    val address: String
    fun changeLightsState(state: Boolean)
}
