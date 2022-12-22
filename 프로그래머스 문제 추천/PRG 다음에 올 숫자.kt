import java.util.*
import java.io.*

fun main() {
    var common = intArrayOf(2, 4, 8)
    println(solution(common))
} // End of main

private fun solution(common: IntArray): Int {
    val size = common.size
    val dif = Math.abs(common[0] - common[1])
    val dif2 = Math.abs(common[1] - common[2])

    // 등차수열
    if (dif == dif2) {
        if (common[0] > common[1]) {
            return common[size - 1] - dif
        }

        return common[size - 1] + dif
    }

    // 등비수열
    val max = Math.max(common[size - 2], common[size - 1])
    val min = Math.min(common[size - 2], common[size - 1])
    val temp = max / min

    //감소하는 등비수열
    if (common[size - 2] > common[size - 1]) {
        return common[size - 1] / temp
    }

    return common[size - 1] * temp
} // End of solution