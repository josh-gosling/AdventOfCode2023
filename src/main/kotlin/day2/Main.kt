package day2


import java.io.File

fun solvePart1(input: List<String>): Int {
    val possibleGames = mutableListOf<String>()
    input.forEach {
        val subsets = it.split(": ")[1].split("; ")
        val id = it.split(": ")[0]
        var isPossible = true

        subsets.forEach {
            var greenCount = 0
            var redCount = 0
            var blueCount = 0
            val cubesRevealed = it.split(", ")
            cubesRevealed.forEach {
                val quantity = it.split(" ")[0].toInt()
                val colour = it.split(" ")[1]

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
    }
    println(possibleGames)
    return possibleGames.map { it.split("Game ")[1].toInt() }.sumOf { it }
}

fun main() {
    val input = File("inputs/day2.txt").readText().replace("\r", "").split("\n")
    println(solvePart1(input))
}
