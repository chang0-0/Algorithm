package BOJ_28445

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*


// input
private lateinit var br: BufferedReader

// variables
private val arr = Array(4) { "" }
private val comb = Array(2) { "" }
private val treeSet = TreeSet<String>()

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_28445\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    solve(0, 0)

    val sb = StringBuilder()
    treeSet.forEach {
        sb.append(it).append('\n')
    }

    bw.write(sb.toString())
    bw.close()
} // End of main()

private fun solve(depth: Int, idx: Int) {
    if (depth == 2) {
        val sb = StringBuilder()
        comb.forEach {
            sb.append(it).append(' ')
        }

        treeSet.add(sb.toString())
        return
    }

    for (i in idx until 4) {
        comb[depth] = arr[i]
        solve(depth + 1, idx)
    }
} // End of solve()

private fun input() {
    StringTokenizer(br.readLine()).run {
        arr[0] = nextToken()
        arr[1] = nextToken()
    }

    StringTokenizer(br.readLine()).run {
        arr[2] = nextToken()
        arr[3] = nextToken()
    }

    arr.sort()
} // End of input()
