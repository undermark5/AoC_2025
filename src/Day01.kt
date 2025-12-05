fun main() {
    val dialStart = 50


    fun part1(input: List<String>): Int {
        var curPoint = dialStart
        var curCount = 0
        input.forEach {
            val magnitude = it.drop(1).toInt()
            val direction = it.first()
            if (direction == 'R') {
                curPoint += magnitude
                curPoint %= 100
            } else {
                curPoint += 100 - magnitude
                curPoint %= 100
            }
            if (curPoint == 0) {
                curCount++
            }
        }
        return curCount
    }

    fun part2(input: List<String>): Long {
        var curPoint = dialStart
        var curCount = 0L
        input.forEach {
            val magnitude = it.drop(1).toInt().let {
                if (it >= 100) {
                    curCount += it / 100
                    it % 100
                } else {
                    it
                }
            }
            val direction = it.first()
            if (direction == 'R') {
                val prevPoint = curPoint
                curPoint += magnitude
                curPoint %= 100
                if ((curPoint <= prevPoint && prevPoint != 0) || curPoint == 0) {
                    curCount++
                }
            } else {
                val prevPoint = curPoint
                curPoint += 100 - magnitude
                curPoint %= 100
                if ((curPoint >= prevPoint && prevPoint != 0) || curPoint == 0) {
                    curCount++
                }
            }
        }
        return curCount
    }

    val testInput = readInput("Day01_test").lines()
    check(part1(testInput) == 3)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01").lines()
//    part1(input).println()
    check(part2(testInput) == 6L)
    part2(input).println()
}
