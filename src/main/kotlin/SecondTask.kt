package org.example

fun main() {
    val matrix = mutableListOf<MutableList<Int>>()
    println("Input N:")
    val n = readln()
    n.toIntOrNull()?.let { size ->
        repeat(size) {
            val tempList = mutableListOf<Int>()
            repeat(size) {
                tempList.add((-1 * size..size).random())
            }
            matrix.add(tempList)
        }
        println(matrix)
        if (size > 0) {
            println("Result of first task:")
            firstTask(matrix)
            println("Result of second task:")
            secondTask(matrix)
        }
    }
}

fun firstTask(matrix: List<List<Int>>) {
    val resultArray = mutableListOf<Int>()
    val tempArray = mutableListOf<Int>()

    matrix.flatten().run {
        forEachIndexed { index, item ->
            if (index == 0) {
                tempArray.add(item)
            } else if (item >= this[index - 1]) {
                tempArray.add(item)
            } else {
                if (tempArray.size > resultArray.size) {
                    resultArray.clear()
                    resultArray.addAll(tempArray)
                }
                tempArray.clear()
                tempArray.add(item)
            }
        }

        println("The largest increasing sequence:")
        println(resultArray)

        tempArray.clear()
        resultArray.clear()

        forEachIndexed { index, item ->
            if (index == 0) {
                tempArray.add(item)
            } else if (item <= this[index - 1]) {
                tempArray.add(item)
            } else {
                if (tempArray.size > resultArray.size) {
                    resultArray.clear()
                    resultArray.addAll(tempArray)
                }
                tempArray.clear()
                tempArray.add(item)
            }
        }

        println("The largest decreasing  sequence:")
        println(resultArray)

    }

}

fun secondTask(matrix: MutableList<MutableList<Int>>) {
    matrix.forEach { list ->
        var firstIndex =  -1
        var secondIndex = -1

        list.forEachIndexed { index, item ->
            if (item > 0 && (firstIndex == -1 || secondIndex == -1)) {
                if (firstIndex == -1) {
                    firstIndex = index
                } else {
                    secondIndex = index
                }
            }
        }

        var sum = 0
        if (firstIndex != -1 && secondIndex != -1) {
            for (i in firstIndex+1..<secondIndex) {
                sum += list[i]
            }
        }

        println(sum)
    }
}