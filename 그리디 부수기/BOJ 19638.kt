package BOJ_19638

import java.io.File
import java.util.PriorityQueue
import java.util.StringTokenizer


// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var H = 0L
private var T = 0
private lateinit var que: PriorityQueue<Long>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_19638\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    var count = 0
    var flag = false
    while (T-- > 0) {
        val cur = que.peek()
        if (cur == 1L || cur < H) {
            flag = true
            break
        }
        que.poll()
        que.offer(cur / 2)
        count++
    }

    if (que.peek() < H) {
        sb.append("YES").append('\n').append(count)
    } else {
        sb.append("NO").append('\n').append(que.poll())
    }

    return sb.toString()
} // End of solve()

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt()
        H = nextToken().toLong()
        T = nextToken().toInt()
    }

    que = PriorityQueue(reverseOrder())
    repeat(N) {
        que.offer(br.readLine().toLong())
    }
} // End of input()