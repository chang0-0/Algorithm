package BOJ_11497

import java.io.*
import java.util.Arrays
import java.util.StringTokenizer


// input
private var br = System.`in`.bufferedReader()

// variables

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_11497\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    val t = br.readLine().toInt()
    repeat(t) {
        bw.write(solve())
    }

    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    val N = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())
    val arr = IntArray(N) {
        st.nextToken().toInt()
    }

    Arrays.sort(arr)
    val que = ArrayDeque<Int>()
    for (i in 0 until N) {
        if (i % 2 == 0) {
            que.addLast(arr[i])
        } else {
            que.addFirst(arr[i])
        }
    }

    var max = Math.abs(que.last() - que.first())
    var pre = que.removeFirst()
    repeat(N - 1) {
        val temp = que.removeFirst()
        max = Math.max(max, Math.abs(temp - pre))
        pre = temp
    }

    sb.append(max).append('\n')
    return sb.toString()
} // End of solve()
