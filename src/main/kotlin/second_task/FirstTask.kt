package org.example.second_task

fun main() {
    val engineer = Engineer("Bob")
    val employer = Employer("Tom")

    engineer.doWork()
    employer.doWork()
    employer.fire(engineer)
}

class Employer(override val name: String) : Engineer(name) {
    override fun doWork() = println("Sign a document")

    fun fire(employee: Employee) = println("${employee.name} was fired")
}

open class Engineer(override val name: String) : Employee {
    override fun doWork() = println("Building Plane")
}

interface Employee {

    val name: String
    fun doWork()

}