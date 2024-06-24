package BOJ_20311

import java.io.BufferedReader
import java.io.File
import java.util.PriorityQueue
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/20311
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var K = 0
private lateinit var tubes: Array<Tube>

private data class Tube(var color: Int = 0, var count: Int = 0) : Comparable<Tube> {
    override fun compareTo(o: Tube): Int {
        return o.count - count
    }
} // End of Tube class

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_20311\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    // 자신을 제외한 많은 값 부터 설정
    val pque = PriorityQueue<Tube>()
    tubes.forEach {
        pque.offer(it)
    }

    val list = mutableListOf<Int>()
    var pre = pque.poll()
    list.add(pre.color)
    pre.count--

    while (pque.isNotEmpty()) {
        var now = pque.peek()

        if (pre.color != now.color) {
            // 이 전 값이랑 다르다.
            now = pque.poll()
            list.add(now.color)
            if (pre.count != 0) {
                pque.offer(pre)
            }
            now.count--
            pre = now
        } else {
            break
        }
    }

    if (pque.isNotEmpty()) {
        list.add(pque.poll().color)
    }

    if (list.size == N) {
        list.forEach {
            sb.append(it).append(' ')
        }
    } else {
        sb.append(-1)
    }

    return sb.toString()
} // End of solve()

private fun input() {
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    K = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    tubes = Array(K) { idx ->
        Tube(idx + 1, st.nextToken().toInt())
    }
} // End of input()
