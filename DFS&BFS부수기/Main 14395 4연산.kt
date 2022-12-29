package `DFS&BFS 부수기`

/*
    정수 S가 주어진다. 정수 S의 값을 T로 바꾸는 최소 연산 횟수를 구하시오.
    사용할 수 있는 연산은 아래와 같다.

    1. S = S + S; (출력 + )

    연산의 아스키 코드 순서는 * , + , - , / 이다.


    S와 T가 같은 경우에는 0을 바꿀 수 없는 경우에는 -1을 출력한다.
    가능한 방법이 여러 가지라면, 사전 순으로 앞서는 것을 출력한다.
 */


import java.util.*
import java.io.*

private var S = 0L
private var T = 0L
private var ans = ""

private data class Number(var num: Long = 0, var depth: Int = 0, var oper: String = "")

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\DFS&BFS 부수기\\res\\14395.txt"
    val br = BufferedReader(File(path).bufferedReader())

    val st = StringTokenizer(br.readLine())
    S = st.nextToken().toLong()
    T = st.nextToken().toLong()

    if (S == T) {
        println(0)
        return
    }


    if (BFS() == -1) {
        println(-1)
    } else {
        println(ans)
    }

} // End of main

private fun BFS(): Int {
    val que: Queue<Number> = LinkedList()
    val set = HashSet<Long>()

    que.offer(Number(S, 0, ""))
    // 더 이상 진행하지 않으려면 어디까지가 한계치일까를 생각해봐야한다.

    while (!que.isEmpty()) {
        val poll = que.poll()

        for (i in 0 until 4) {
            var nowNum = poll.num
            var nowDepth = poll.depth
            var nowOper = poll.oper

            if (i == 0) {
                nowNum *= nowNum
                nowOper += "*"
            } else if (i == 1) {
                nowNum += nowNum
                nowOper += "+"
            } else if (i == 2) {
                nowNum -= nowNum
                nowOper += "-"
            } else if (nowNum != 0L) {
                nowNum /= nowNum
                nowOper += "/"
            }

            if (nowNum == T) {
                ans = nowOper
                return nowDepth
            } else if (!set.contains(nowNum)) {
                set.add(nowNum)
                que.offer(Number(nowNum, nowDepth + 1, nowOper))
            }
        }
    }

    return -1
} // End of BFS