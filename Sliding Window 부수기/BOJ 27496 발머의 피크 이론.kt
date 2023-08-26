package BOJ_27496

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// https://www.acmicpc.net/problem/27496
// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var L = 0
private var ans = 0

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_27496\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    sb.append(ans)
    return sb.toString()
} // End of solve()

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt()
        L = nextToken().toInt()
    }

    var sum = 0L
    val que: Queue<Int> = LinkedList()
    StringTokenizer(br.readLine()).run {
        for (i in 1..N) {
            val temp = nextToken().toInt()
            que.offer(temp)

            sum += temp
            if (que.size > L) {
                sum -= que.poll()
            }

            if (sum in 129..138) ans++
        }
    }
} // End of input()
