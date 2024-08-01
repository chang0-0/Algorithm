package BOJ_1327

import java.io.BufferedReader
import java.io.File
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/1327
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var K = 0
private lateinit var arr: CharArray
private lateinit var clone: CharArray
private var arrStr = ""
private var cloneStr = ""

private data class Swap(var str: String, var cnt: Int)

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_1327\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    clone = arr.clone()
    arr.sort()
    arrStr = String(arr)
    cloneStr = String(clone)

    sb.append(BFS())
    return sb.toString()
} // End of solve()

private fun BFS(): Int {
    val que = ArrayDeque<Swap>()
    que.addLast(Swap(cloneStr, 0))
    val set = HashSet<Int>()

    while (que.isNotEmpty()) {
        val cur = que.removeFirst()

        if (cur.str == arrStr) return cur.cnt

        if (set.add(cur.str.toInt())) {
            for (i in 0..N - K) {
                que.addLast(Swap(makeStr(cur.str, i, i + K), cur.cnt + 1))
            }
        }
    }

    return -1
} // End of BFS()

private fun makeStr(str: String, i: Int, j: Int): String {
    val sb = StringBuilder()

    sb.append(str, 0, i)
    val temp = str.substring(i, j)
    for (i in K - 1 downTo 0) {
        sb.append(temp[i])
    }

    sb.append(str, j, str.length)
    return sb.toString()
} // End of makeStr()

private fun input() {
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    K = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    arr = CharArray(N) {
        st.nextToken()[0]
    }
} // End of input()
