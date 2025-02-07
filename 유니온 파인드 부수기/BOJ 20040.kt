package BOJ_20040

import java.io.File
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/20040
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var M = 0
private lateinit var parents: IntArray
private lateinit var ranks: IntArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_20040\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    for (i in 0 until M) {
        val st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        if (find(a) == find(b)) {
            sb.append(i + 1)
            return sb.toString()
        }

        union(a, b)
    }

    sb.append(0)
    return sb.toString()
} // End of solve()

private fun union(a: Int, b: Int) {
    val rootA = find(a)
    val rootB = find(b)
    parents[a] = rootA
    parents[b] = rootB

    if (rootA == rootB) return

    // Union by Rank (랭크 기반 합치기)
    if (ranks[rootA] < ranks[rootB]) {
        parents[rootA] = rootB
    } else if (ranks[rootA] > ranks[rootB]) {
        parents[rootB] = rootA
    } else {
        parents[rootB] = rootA
        ranks[rootA]++
    }
} // End of union()

private fun find(node: Int): Int {
    // 경로 압축(Path Compression)
    if (parents[node] != node) {
        parents[node] = find(parents[node])
    }

    return parents[node]
} // End of find()

private fun input() {
    val st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    parents = IntArray(N) {
        it
    }
    ranks = IntArray(N)
} // End of input()
