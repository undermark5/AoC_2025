fun main() {
    fun part1(input: List<String>): Long {
        val regex = Regex("""^(\d+?)\1$""")
        val ranges = input.map { val (low, high) = it.split("-") ; low.toLong()..high.toLong()}
        return ranges.sumOf {
            it.map { it.toString() }.filter {
                it.contains(regex)
            }.sumOf { it.toLong() }
        }
    }

    fun part2(input: List<String>): Long {
        val regex = Regex("""^(\d+?)\1+$""")
        val ranges = input.map { val (low, high) = it.split("-") ; low.toLong()..high.toLong()}
        return ranges.sumOf {
            it.map { it.toString() }.filter {
                it.contains(regex)
            }.sumOf { it.toLong() }
        }
    }

    val testInput = readInput("Day02_test").split(",").map { it.trim() }
    check(part1(testInput) == 1227775554L)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02").split(",").map { it.trim() }
    part1(input).println()
    check(part2(testInput) == 4174379265L)
    part2(input).println()
}
