package org.example.second_task

fun main() {
    val theater = Theater("Theatre Square, 1", false, "Big Theater")

    theater.changeLightsState(true)
    theater.changeState(true)
}

class Theater(override val address: String, override var state: Boolean, override val name: String) :
    PublicBuilding(address, state, name) {
    override fun changeState(newState: Boolean) {
        super.changeState(newState)
        println("New state: $state")
    }

}

abstract class PublicBuilding(
    override val address: String,
    protected open var state: Boolean,
    protected open val name: String
) : Building {
    open fun changeState(newState: Boolean) {
        state = newState
    }

    override fun changeLightsState(state: Boolean) =
        println("Lights ${if (state) java.lang.String("on") else java.lang.String("off")}")

}

interface Building {

    val address: String
    fun changeLightsState(state: Boolean)
}
