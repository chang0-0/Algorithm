package BOJ_20291

import java.io.*
import java.util.StringTokenizer
import java.util.TreeMap

// https://www.acmicpc.net/problem/20291
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private lateinit var map: TreeMap<String, Int>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_20291\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    for (i in 0 until N) {
        val st = StringTokenizer(br.readLine(), ".")
        st.nextToken()
        val temp = st.nextToken();
        map.put(temp, map.getOrDefault(temp, 0) + 1)
    }

    map.forEach {
        sb.append(it.key).append(' ').append(it.value).append('\n')
    }

    return sb.toString()
} // End of solve()

private fun input() {
    N = br.readLine().toInt()
    map = TreeMap<String, Int>()
} // End of input()
