package BOJ_5397

import java.io.File
import java.util.LinkedList

// https://www.acmicpc.net/problem/5397
// input
private var br = System.`in`.bufferedReader()

// variables
private var str = ""

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_5397\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    val T = br.readLine().toInt()
    repeat(T) {
        input()

        bw.write(solve())
    }

    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    val N = str.length
    val que: MutableList<Char> = LinkedList()
    val iter = que.listIterator()

    for (i in 0 until N) {
        val ch = str[i]


        if (ch == '<') {
            if (iter.hasPrevious()) iter.previous()
        } else if (ch == '>') {
            if (iter.hasNext()) iter.next()
        } else if (ch == '-') {
            if (iter.hasPrevious()) {
                iter.previous()
                iter.remove()
            }
        } else {
            iter.add(ch)
        }
    }

    while (que.isNotEmpty()) {
        sb.append(que.removeFirst())
    }

    sb.append('\n')
    return sb.toString()
} // End of solve()

private fun input() {
    str = br.readLine()
} // End of input()
