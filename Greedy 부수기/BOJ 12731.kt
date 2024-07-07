package BOJ_12731

import java.io.BufferedReader
import java.io.File
import java.util.PriorityQueue
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/12731
// input
private var br = System.`in`.bufferedReader()

// variables
private var T = 0
private var NA = 0
private var NB = 0

private lateinit var arr: Array<Train>
private lateinit var sb: StringBuilder

private data class Train(var type: Char, var start: Int, var end: Int) : Comparable<Train> {
    override fun compareTo(o: Train): Int {
        if (start == o.start) {
            return end - o.end
        }

        return start - o.start
    }
} // End of Time class

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_12731\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = System.out.bufferedWriter()

    val N = br.readLine().toInt()
    for (i in 1..N) {
        input()

        bw.apply {
            write("Case #")
        }
        sb.append(i).append(": ")
        bw.write(solve())
    }

    bw.close()
} // End of main()

private fun solve(): String {
    /*
        모든 출발과 도착은 하루 안에 일어난다.
        각 테스트 케이스 마다 A역과 B역에서 출발시켜야 하는 차량의 수를 출력하시오.
     */

    arr.sort()
    val aTobPque = PriorityQueue<Int>()
    val bToaPque = PriorityQueue<Int>()
    var ans1 = 0
    var ans2 = 0

    for (i in 0 until NA + NB) {
        val cur = arr[i]

        if (cur.type == 'A') {
            ans1 += check(cur, aTobPque, bToaPque)
        } else {
            ans2 += check(cur, bToaPque, aTobPque)
        }
    }

    sb.append(ans1).append(' ').append(ans2).append('\n')
    return sb.toString()
} // End of solve()

private fun check(cur: Train, start: PriorityQueue<Int>, end: PriorityQueue<Int>): Int {
    end.offer(cur.end + T)

    if (start.isEmpty() || (cur.start < start.peek())) {
        return 1
    } else {
        start.poll()
        return 0
    }

} // End of check()

private fun input() {
    T = br.readLine().toInt()
    sb = StringBuilder()

    var st = StringTokenizer(br.readLine())
    var timeToken: StringTokenizer
    NA = st.nextToken().toInt()
    NB = st.nextToken().toInt()
    var type: Char = ' '
    var idx = 0

    arr = Array<Train>(NA + NB) {
        st = StringTokenizer(br.readLine())
        var temp = st.nextToken()
        timeToken = StringTokenizer(temp, ":")

        val startM = timeToken.nextToken().toInt() * 60 + timeToken.nextToken().toInt()

        temp = st.nextToken()
        timeToken = StringTokenizer(temp, ":")
        val endM = timeToken.nextToken().toInt() * 60 + timeToken.nextToken().toInt()

        if (idx < NA) {
            type = 'A'
        } else {
            type = 'B'
        }
        idx++

        Train(
            type,
            startM,
            endM
        )
    }
} // End of input()
