package BOJ_1717

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*


// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var M = 0
private lateinit var parent: IntArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_1717\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    repeat(M) {
        StringTokenizer(br.readLine()).run {
            val f = nextToken().toInt()
            val a = nextToken().toInt()
            val b = nextToken().toInt()

            when (f) {
                0 -> {
                    union(a, b)
                }

                else -> {
                    if (find(a) == find(b)) {
                        sb.append("YES")
                    } else {
                        sb.append("NO")
                    }
                    sb.append('\n')
                }
            }
        }
    }

    return sb.toString()
} // End of solve()

private fun find(x: Int): Int {
    if (x == parent[x]) return x

    parent[x] = find(parent[x])
    return parent[x]
} // End of find()

private fun union(a: Int, b: Int) {
    val aParent = find(a)
    val bParent = find(b)

    if (aParent != bParent) {
        parent[aParent] = bParent;
    }
} // End of union()

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt()
        M = nextToken().toInt()
    }

    parent = IntArray(N + 1) { idx ->
        idx
    }
} // End of input()
