package BOJ_27375

import java.io.File
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/27375
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var K = 0
private var ans = 0
private lateinit var arr: Array<IntArray>
private lateinit var isVisited: BooleanArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_27375\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    arr.sortWith { o1, o2 ->
        if (o1[0] == o2[0]) {
            if (o1[1] == o2[1]) {
                o1[2] - o2[2]
            } else {
                o1[1] - o2[1]
            }
        } else {
            o1[0] - o2[0]
        }
    }

    isVisited = BooleanArray(N)
    DFS(0, 0, 0, 0)

    sb.append(ans)
    return sb.toString()
} // End of solve()

private fun DFS(idx: Int, day: Int, endTime: Int, sumTime: Int) {
    if (sumTime == K) {
        ans++
        return
    } else if (sumTime > K) return // K학점을 넘으면 안된다.

    for (i in idx until N) {
        if (arr[i][0] == 5) continue // 금요일은 제외
        if (day == arr[i][0] && endTime >= arr[i][1]) continue // 같은 요일에, 이전 수업 끝나는 시간과, 다음 수업 시작 시간이 겹치면 들을 수 없다.
        if (isVisited[i]) continue
        isVisited[i] = true
        val time = (arr[i][2] - arr[i][1]) + 1
        DFS(i, arr[i][0], arr[i][2], sumTime + time)
        isVisited[i] = false
    }
} // End of DFS()

private fun input() {
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    K = st.nextToken().toInt()

    arr = Array(N) {
        st = StringTokenizer(br.readLine())
        IntArray(3) {
            st.nextToken().toInt()
        }
    }
} // End of input()

// 1 10 10 -> 1
// 3 2 5 -> 4
// 2 6 10 -> 5
// 3 6 10 -> 5