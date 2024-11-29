package BOJ_30827

import java.io.*
import java.util.PriorityQueue
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/30827
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var K = 0

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_30827\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    val comp = object : Comparator<IntArray> {
        override fun compare(o1: IntArray, o2: IntArray): Int {
            return o1[1].compareTo(o2[1])
        }
    }

    val que = PriorityQueue<IntArray>(comp)
    repeat(N) {
        StringTokenizer(br.readLine()).run {
            val a = IntArray(2) {
                nextToken().toInt()
            }

            que.offer(a)
        }
    }


    val rooms = IntArray(K)
    var ans = 0

    while (que.isNotEmpty()) {
        val cur = que.poll()
        rooms.sort()

        // for(int i=K-1; i>=0; i--)
        for (i in K - 1 downTo 0) {
            if (rooms[i] < cur[0]) {
                rooms[i] = cur[1]
                ans++
                break
            }
        }
    }

    sb.append(ans)
    return sb.toString()
} // End of solve()

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt()
        K = nextToken().toInt()
    }
} // End of input()
