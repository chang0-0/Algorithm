package BOJ_2493

import java.io.File
import java.util.StringTokenizer


// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private lateinit var arr: IntArray

private data class Top(var num: Int, var idx: Int)

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_2493\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    // 앞에 있는 탑 보다, 새로들어오는 탑의 높이가 더 클 경우 앞은 제거.
    val que = ArrayDeque<Top>()
    que.add(Top(arr[0], 1))
    sb.append(0).append(' ')

    for (i in 1 until N) {

        while (que.isNotEmpty() && que.last().num <= arr[i]) {
            que.removeLast()
        }

        if (que.isEmpty()) {
            sb.append(0)
        } else {
            val size = que.size
            for (j in size - 1 downTo 0) {
                if (que.get(j).num >= arr[i]) {
                    sb.append(que.get(j).idx)
                    break
                }
            }
        }

        que.addLast(Top(arr[i], i + 1))
        sb.append(' ')
    }

    return sb.toString()
} // End of solve()

private fun input() {
    N = br.readLine().toInt()
    arr = IntArray(N)

    StringTokenizer(br.readLine()).let {
        for (i in 0 until N) {
            arr[i] = it.nextToken().toInt()
        }
    }
} // End of input()
