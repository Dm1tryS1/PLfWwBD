package fourthTask.university

data class University(
    private val students: MutableList<Student> = mutableListOf(),
    private val teachers: MutableList<Teacher> = mutableListOf(),
) {
    fun getAverageMark() {
        println(
            if (students.isNotEmpty()) {
                students.mapNotNull { it.testResult?.mark }.let { list ->
                    if (list.isNotEmpty()) {
                        "Average value: ${list.sumOf { it.getValue() } / list.size}"
                    } else {
                        "No test checked"
                    }
                }
            } else {
                "Nobody write test"
            }
        )
    }

    fun resultList() {
        students.filter { it.testResult != null }.let { list ->
            if (list.none { it.testResult?.mark == null }) {
                println("Input passing score")
                val passingScore = readln().toIntOrNull() ?: MIN_MARK
                if (passingScore in MIN_MARK..MAX_MARK) {
                    val result = list.filter { (it.testResult?.mark?.getValue() ?: MIN_MARK) >= passingScore }
                    if (result.isNotEmpty()) {
                        println("Students passed test")
                        result.forEachIndexed { index, student ->
                            println("${index + 1}: $student")
                        }
                    } else {
                        println("No student passed test")
                    }
                }
            }
        }
    }

    private fun chooseStudent(): Student? {
        println("Choose student")
        students.forEachIndexed { index, student ->
            println("${index + 1}: $student")
        }
        return readln().toIntOrNull()?.let { index ->
            students.getOrNull(index - 1)
        }
    }

    fun chooseStudentAction() {
        chooseStudent()?.let {
            println("Choose action")
            println("1: Write test")
            when (readln().toIntOrNull() ?: 0) {
                1 -> it.writeTest()
                else -> {}
            }
        }
    }

    fun chooseTeacherAction() {
        println("Choose teacher")
        teachers.forEachIndexed { index, student ->
            println("${index + 1}: $student")
        }
        readln().toIntOrNull()?.let { index ->
            teachers.getOrNull(index - 1)?.let { teacher ->
                chooseStudent()?.let {
                    println("Choose action")
                    println("1: check test")
                    when (readln().toIntOrNull() ?: 0) {
                        1 -> teacher.checkTest(it)
                        else -> {}
                    }
                }
            }
        }
    }

    fun createStudent() {
        println("What is your name?")
        val fullName = readln()
        println("What is your gender?")
        println("1: Female")
        println("2: Male")
        val gender = when (readln().toIntOrNull() ?: 0) {
            1 -> false
            2 -> true
            else -> false
        }
        students.add(Student(fullName = fullName, gender = gender))
    }


    companion object {
        const val MAX_MARK = 100
        const val MIN_MARK = 0
    }

}
