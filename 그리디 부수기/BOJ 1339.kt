package BOJ_1339

import java.io.File
import java.util.*


// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private lateinit var map: HashMap<Char, Int>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_1339\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    val mapList = map.toList()
    val sortedByValue: List<Pair<Char, Int>> = mapList.sortedByDescending { (k, v) -> v }
    var digit = 9
    var sum = 0

    sortedByValue.forEach {
        sum += it.second * digit
        digit--
    }

    sb.append(sum)
    return sb.toString()
} // End of solve()

private fun input() {
    N = br.readLine().toInt()
    map = HashMap<Char, Int>()

    repeat(N) {
        val temp = br.readLine()

        val len = temp.length
        for (i in 0 until len) {
            val ch = temp[i]
            val weight = Math.pow(10.0, (len - i - 1).toDouble()).toInt()
            map.put(ch, map.getOrDefault(ch, 0) + weight)
        }
    }
} // End of input()
