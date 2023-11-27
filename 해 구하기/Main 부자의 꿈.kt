package 부자의_꿈

import java.io.BufferedReader
import java.io.File
import java.util.*

// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var M = 0
private var Q = 0

private lateinit var map: Array<IntArray>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\부자의_꿈\\res.txt"
    br = BufferedReader(File(path).bufferedReader())

    var T = br.readLine().toInt()
    while (T-- > 0) {
        input()


    }

} // End of main

private fun input() {
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    Q = st.nextToken().toInt()

    map = Array(N + 1) { IntArray(M + 1) }
    for (i in 1..N) {
        st = StringTokenizer(br.readLine())
        for (j in 1..M) {
            map[i][j] = st.nextToken().toInt()
        }
    }

    map.forEach {
        println(it.contentToString())
    }


} // End of input