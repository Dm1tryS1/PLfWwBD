package fourth

import java.io.FileWriter
import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    Files.deleteIfExists(Paths.get(FileName.ResultFirst.name))
    Files.deleteIfExists(Paths.get(FileName.ResultSecond.name))
    Files.deleteIfExists(Paths.get(FileName.InputSecond.name))
    doFirstTask()

    println("Input n")
    val n = readln().toIntOrNull() ?: 1
    repeat(n) {
        writeToFile(readln(), FileName.InputSecond)
    }
    doSecondTask()
}

fun writeToFile(value: String, name: FileName) {
    FileWriter(name.name, true).use { out ->
        out.write(value + "\n")
    }
}

fun doFirstTask() {
    Files.lines(Paths.get(FileName.InputFirst.nameFile)).use { stream ->
        stream.forEach { value ->
            writeToFile(
                value.split(" ").joinToString(" ") {
                    if (it.length > 2) {
                        it.uppercase()
                    } else {
                        it
                    }
                },
                FileName.ResultFirst
            )
        }
    }
}

fun doSecondTask() {
    Files.lines(Paths.get(FileName.InputSecond.name)).use { stream ->
        stream.forEach { value ->
            val listOfMarks = value.split(" ").mapNotNull { it.toIntOrNull() }
            writeToFile(
                if (listOfMarks.sum() / listOfMarks.size > AVG_MARK) {
                    value.split(" ").toMutableList().apply { this[0] = this[0].uppercase() }.joinToString(" ")
                } else {
                    value
                }, FileName.ResultSecond
            )

        }
    }
}

enum class FileName(val nameFile: String) {
    ResultFirst(""),
    ResultSecond(""),
    InputFirst("./src/main/kotlin/fourth/Main.kt"),
    InputSecond("")
}

const val AVG_MARK = 7