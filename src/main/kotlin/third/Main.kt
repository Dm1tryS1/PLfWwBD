package third

import java.io.FileWriter
import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    Files.deleteIfExists(Paths.get(FileName.Input.name))
    Files.deleteIfExists(Paths.get(FileName.ResultFirst.name))
    Files.deleteIfExists(Paths.get(FileName.ResultSecond.name))
    println("Input n")
    val n = readln().toIntOrNull() ?: 1
    repeat(n) {
        writeToFile(readln(), FileName.Input)
    }
    doFirstTask()
    doSecondTask()
}

fun writeToFile(value: String, name: FileName) {
    FileWriter(name.name, true).use { out ->
        out.write(value + "\n")
    }
}

fun doFirstTask() {
    Files.lines(Paths.get(FileName.Input.name)).use { stream ->
        stream.forEach { value ->
            writeToFile(
                value.split(" ").filter { it.firstOrNull()?.isUpperCase() ?: false }.joinToString(" "),
                FileName.ResultFirst
            )
        }
    }
}

fun doSecondTask() {
    Files.lines(Paths.get(FileName.Input.name)).use { stream ->
        stream.forEach { value ->
            writeToFile(
                value.split(" ").let { list ->
                    list.filterIndexed { index, value ->
                        if (index < list.size - 1) {
                            try {
                                value.last().lowercase() == list[index + 1].first().lowercase()
                            } catch (e: NoSuchElementException) {
                                false
                            }
                        } else {
                            false
                        }
                    }.joinToString(" ")
                },
                FileName.ResultSecond
            )
        }
    }
}

enum class FileName {
    ResultFirst,
    ResultSecond,
    Input
}