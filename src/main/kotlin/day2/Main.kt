package day2


import java.io.File

fun solvePart2(subsets: List<String>): Int {
    var greenMin = 0
    var redMin = 0
    var blueMin = 0
    subsets.forEach { subset ->
        val cubesRevealed = subset.split(", ")
        cubesRevealed.forEach { cube ->
            val quantity = cube.split(" ")[0].toInt()
            val colour = cube.split(" ")[1]

            when (colour) {
                "blue" -> if (quantity > blueMin) {
                    blueMin = quantity
                }

                "red" -> if (quantity > redMin) {
                    redMin = quantity
                }

                "green" -> if (quantity > greenMin) {
                    greenMin = quantity
                }
            }
        }
    }
    return greenMin * blueMin * redMin
}

fun solvePart1(id: String, subsets: List<String>): MutableList<String> {
    val possibleGames = mutableListOf<String>()
    var isPossible = true
    subsets.forEach { subset ->
        var greenCount = 0
        var redCount = 0
        var blueCount = 0
        val cubesRevealed = subset.split(", ")
        cubesRevealed.forEach { cube ->
            val quantity = cube.split(" ")[0].toInt()
            val colour = cube.split(" ")[1]

            when (colour) {
                "blue" -> blueCount += quantity
                "red" -> redCount += quantity
                "green" -> greenCount += quantity
            }
        }
        if (!(redCount <= 12 && greenCount <= 13 && blueCount <= 14)) {
            isPossible = false
        }
    }
    if (isPossible) {
        possibleGames.add(id)
    }
    return possibleGames
}

fun loopGames(input: List<String>): List<Int> {
    val possibleGames = mutableListOf<String>()
    val minNumber = mutableListOf<Int>()
    input.forEach { game ->
        val subsets = game.split(": ")[1].split("; ")
        val id = game.split(": ")[0]

        possibleGames += solvePart1(id, subsets)
        minNumber += solvePart2(subsets)
    }
    return listOf(possibleGames.map { it.split("Game ")[1].toInt() }.sumOf { it }, minNumber.sumOf { it })
}

fun main() {
    val input = File("inputs/day2.txt").readText().replace("\r", "").split("\n")
    println(loopGames(input))
}
