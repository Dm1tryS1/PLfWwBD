package org.example

fun main() {
    firstTask()
    secondTask()
    thirdTask()
    fourthTask()
    fifthTask()
    sixthTask()
    seventhTask()
    eighthTask()
}

fun firstTask() {
    println("First Task")
    println("Input text")
    val result = readln().split(" ").joinToString(" ") { word ->
        word.replace("PA", "PO")
        word.replace("Pa", "Po")
        word.replace("pA", "pO")
        word.replace("pa", "po")
    }
    println(result)
}

fun secondTask() {
    println("Second Task")
    println("Input n")
    val n = readln().toIntOrNull() ?: 1
    println("Input new word")
    val newWord = readln()

    println("Input text")
    val result = readln().split(" ").map { it.removeIfNotLetter() }.joinToString(" ") { word ->
        if (word.length == n) {
            newWord
        } else {
            word
        }
    }
    println(result)
}

fun thirdTask() {
    println("Third Task")
    println("Input n")
    val n = readln().toIntOrNull() ?: 1
    println("Input text")
    val map = mutableMapOf<Char, Int>()
    readln().forEach {
        if (it.isLetter()) {
            map[it.lowercase().toCharArray()[0]] = (map[it.lowercase().toCharArray()[0]] ?: 0) + 1
        }
    }
    val result = map.entries.sortedBy { it.value }.reversed().take(n)
    println(result)
}

fun fourthTask() {
    println("Fourth Task")
    println("Input text")
    readln().split(".", "?", "!").forEachIndexed { index, sentence ->
        var countOfConsonants = 0
        var countOfVowels = 0
        sentence.forEach {
            if (it.isLetter()) {
                if (listOf("a", "o", "e", "i", "u", "y").contains(it.lowercase())) {
                    countOfVowels += 1
                } else {
                    countOfConsonants += 1
                }
            }
        }
        if (countOfConsonants > countOfVowels) {
            println("In sentence ${index + 1} - consonants ")
        } else if (countOfConsonants < countOfVowels) {
            println("In sentence ${index + 1} - vowels")
        } else {
            println("In sentence ${index + 1} - equals")
        }
    }
}

fun fifthTask() {
    println("Fifth Task")
    println("Input text")
    val map = mutableMapOf<String, Int>()
    readln().split(".", "?", "!").forEachIndexed { index, sentence ->
        sentence.split(" ").map { it.removeIfNotLetter() }.forEach {
            if (index == 0) {
                map[it] = 0
            } else {
                if (map.containsKey(it)) {
                    map[it] = (map[it] ?: 0) + 1
                }
            }
        }
    }
    val result = map.filter { it.value == 0 }
    println(result)
}

fun sixthTask() {
    println("Sixth Task")
    println("Input n")
    val n = readln().toIntOrNull() ?: 1
    println("Input text")
    val result = readln().split("?").map {
        it.replaceBeforeLast('.', "").replaceBeforeLast('!', "").split(" ").map { word ->
            word.removeIfNotLetter()
        }.filter { word -> word.length == n }.distinct()
    }

    println(result)
}

fun seventhTask() {
    println("Seventh Task")
    println("Input text")
    val result =
        readln().split(" ").map { it.removeIfNotLetter() }.sortedBy { it.length }.reversed().groupBy { it.length }
            .map {
                it.value.sortedBy { word ->
                    word.filter { letter ->
                        listOf("a", "o", "e", "i", "u", "y").contains(letter.lowercase())
                    }.length
                }.reversed()
            }.flatten()

    println(result)
}

fun eighthTask() {
    println("EighthTask Task")
    println("Input first letter")
    val firstLetter = readln().toCharArray().getOrNull(0) ?: 'a'
    println("Input second letter")
    val secondLetter = readln().toCharArray().getOrNull(0) ?: 'a'
    println("Input text")
    val result = readln().let { text ->
        val firstIndex = text.indexOfFirst { firstLetter == it }
        val secondIndex = text.indexOfFirst { secondLetter == it }
        if (firstIndex != -1 && secondIndex != -1 && firstIndex < secondIndex) {
            text.removeRange((firstIndex..secondIndex))
        } else {
            text
        }
    }
    println(result)
}

fun String.removeIfNotLetter(): String = this.map {
    if (it.isLetter() || it == '-' || it == '\'') {
        it
    } else {
        ' '
    }
}.joinToString("").replace(" ", "")