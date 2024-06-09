package BOJ_1141

import java.io.*
import java.io.BufferedReader

private var br = System.`in`.bufferedReader()
private var N = 0
private lateinit var arr: Array<String>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_1141\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    arr.sortWith(compareByDescending { it.length })

    val set = HashSet<String>()
    for (s in arr) {
        if (set.isEmpty()) {
            set.add(s)
            continue
        }

        var isPrefix = true
        for (s2 in set) {
            if (s.startsWith(s2) || s2.startsWith(s)) {
                isPrefix = false
                break
            }
        }

        if (isPrefix) {
            set.add(s)
        }
    }

    sb.append(set.size)
    return sb.toString()
} // End of solve()

private fun input() {
    N = br.readLine().toInt()
    arr = Array<String>(N) {
        br.readLine()
    }
} // End of input()
