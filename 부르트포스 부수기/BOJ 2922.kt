package BOJ_2922

import java.io.*

// https://www.acmicpc.net/problem/2922
// input
private var br = System.`in`.bufferedReader()

// variables
private lateinit var chArr: CharArray
private var ans = 0L

private val vowels = arrayOf('A', 'E', 'I', 'O', 'U')
private const val L = 'L'

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_2922\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    DFS(0, 0, 0, false, 1)
    sb.append(ans)
    return sb.toString()
} // End of solve()

private fun DFS(idx: Int, mo: Int, ja: Int, l: Boolean, count: Long) {
    if (mo >= 3 || ja >= 3) return
    if (idx == chArr.size) {
        if (l) ans += count // L이 포함되어 있으면,
        return
    }

    val ch = chArr[idx]
    if (ch == '_') {
        // 빈칸에 들어갈 수 있는 경우 생각,

        DFS(idx + 1, mo + 1, 0, l, count * 5) // 모음 하나 추가

        DFS(idx + 1, 0, ja + 1, l, count * 20)
        // L을 포함하지 않은 자음 20개, 자음 추가, L을 포함해서 21개를 할 경우,
        // L이 전체에 포함되지 않는 경우를 고려하지 못함


        DFS(idx + 1, 0, ja + 1, true, count) // L인 자음을 추가
    } else {
        if (vowels.contains(ch)) {
            DFS(idx + 1, mo + 1, 0, l, count) // 빈칸 아니고 모음일 경우
        } else {
            if (ch == 'L') DFS(idx + 1, 0, ja + 1, true, count) // 빈칸아닌데, L인경우
            else DFS(idx + 1, 0, ja + 1, l, count) // 빈칸 아닌데, 자음인 경우
        }
    }
} // End of DFS()

private fun input() {
    chArr = br.readLine().toCharArray()
} // End of input()
