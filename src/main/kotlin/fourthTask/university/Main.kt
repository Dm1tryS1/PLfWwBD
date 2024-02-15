package fourthTask.university

import java.util.*

fun main() {
    val university = University(teachers = createTeacherList())

    var input = showMenu(university)
    while (input.lowercase(Locale.getDefault()) != "exit") {
        input = showMenu(university)
    }
}

fun showMenu(university: University): String {
    println("Choose action")
    println("1: create student")
    println("2: student action")
    println("3: teacher action")
    println("4: show average mark")
    println("5: show student passed test")
    println("exit: For Exit")
    val input = readln()
    when (input.toIntOrNull() ?: 0) {
        1 -> university.createStudent()
        2 -> university.chooseStudentAction()
        3 -> university.chooseTeacherAction()
        4 -> university.getAverageMark()
        5 -> university.resultList()
        else -> {}
    }
    return input
}

fun createTeacherList() = mutableListOf(
    Teacher(
        fullName = "Teacher 1",
        gender = true,
    ),
    Teacher(
        fullName = "Teacher 2",
        gender = true,
    ),
    Teacher(
        fullName = "Teacher 3",
        gender = true,
    ),
    Teacher(
        fullName = "Teacher 4",
        gender = false,
    ),
    Teacher(
        fullName = "Teacher 4",
        gender = false,
    ),
    Teacher(
        fullName = "Teacher 6",
        gender = true,
    ),
    Teacher(
        fullName = "Teacher 7",
        gender = false,
    )
)