package BOJ_31792

import java.io.File
import java.util.StringTokenizer
import java.util.TreeMap

// https://www.acmicpc.net/problem/31792
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_31792\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()
    val map = TreeMap<Int, Int>()

    repeat(N) {
        val st = StringTokenizer(br.readLine())
        val cmd = st.nextToken().toInt()

        if (cmd == 1) {
            val num = st.nextToken().toInt()
            map[num] = map.getOrDefault(num, 0) + 1
        } else if (cmd == 2) {
            val num = st.nextToken().toInt()
            if (map.containsKey(num)) {
                map[num] = map[num]!! - 1

                if (map[num] == 0) {
                    map.remove(num)
                }
            }
        } else {
            var pageCount = 0
            if (map.isNotEmpty()) {
                pageCount = 1
                var key = map.firstKey()

                while (map.higherKey(key * 2 - 1) != null) {
                    pageCount++
                    key = map.higherKey(key * 2 - 1)
                }
            }

            sb.append(pageCount).append('\n')
        }
    }

    return sb.toString()
} // End of solve()

private fun input() {
    N = br.readLine().toInt()
} // End of input()
